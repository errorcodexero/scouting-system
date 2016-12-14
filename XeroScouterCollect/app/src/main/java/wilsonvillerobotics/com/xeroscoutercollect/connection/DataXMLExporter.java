
package wilsonvillerobotics.com.xeroscoutercollect.connection;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;

import wilsonvillerobotics.com.xeroscoutercollect.database.DatabaseHelper;

/**
 * Created by Luke on 12/13/2016.
 */

public class DataXMLExporter {
    public static final String DATASUBDIRECTORY = "files";
    private final String LOG_TAG = "FTS_XmlExporter";

    private final SQLiteDatabase db;
    //private XmlBuilder xmlBuilder;
    private DatabaseHelper helper;


    public DataXMLExporter(Context c) {
        helper = DatabaseHelper.getInstance(c);
        this.db = helper.getWritableDatabase();
    }

    //public int export(final String dbName, final String exportFileNamePrefix, final String androidUuid, final String timestamp) throws IOException {
   /* public int export(final String dbName) throws IOException {
        //Log.i(LOG_TAG, "exporting database - " + dbName + " exportFileNamePrefix=" + exportFileNamePrefix + "   androidUuid=" + androidUuid + "  timestamp=" + timestamp);
        Log.i(LOG_TAG, "exporting database - " + dbName);

        int exportCount = 0;
        for(helper.TABLE_NAMES tn : DBAdapter.TABLE_NAMES.values()) {
            xmlBuilder = new XmlBuilder();
            xmlBuilder.start(dbName);
            String tableName = tn.getTableName();
            ArrayList<Long> exportedIDs = new ArrayList<Long>();

            try {
                exportedIDs = exportTable(tn.getTableName());
                setDataExported(tableName, exportedIDs);
            } catch(Exception e) {
                e.printStackTrace();
            }
            String xmlString = xmlBuilder.end();

            String xmlFileName = FTSUtilities.getXmlDataFileNameForTable(tableName); // exportFileNamePrefix + "-" + androidUuid + "-" + tableName + "-" + timestamp + ".xml";
            if(exportedIDs.size() > 0 && writeToFile(xmlString, xmlFileName)) exportCount++;
            Log.i(LOG_TAG, "exporting table complete: " + tableName);
        }
        //String xmlString = xmlBuilder.end();
        //if(!c.isClosed()) c.close();
        //String xmlFileName = exportFileNamePrefix + ".xml";
        //boolean exported = writeToFile(xmlString, xmlFileName);
        Log.i(LOG_TAG, "exporting database complete");
        return exportCount;
    }

    public int exportWholeTable(final String dbName, final String tableName) throws IOException {
        //Log.i(LOG_TAG, "exporting database - " + dbName + " exportFileNamePrefix=" + exportFileNamePrefix + "   androidUuid=" + androidUuid + "  timestamp=" + timestamp);
        Log.i(LOG_TAG, "exporting database - " + dbName);

        int exportCount = 0;
        xmlBuilder = new XmlBuilder();
        xmlBuilder.start(dbName);
        ArrayList<Long> exportedIDs = new ArrayList<Long>();

        try {
            exportedIDs = exportWholeTable(tableName);
            setDataExported(tableName, exportedIDs);
        } catch(Exception e) {
            e.printStackTrace();
        }
        String xmlString = xmlBuilder.end();

        String xmlFileName = FTSUtilities.getXmlDataFileNameForTable(tableName); // exportFileNamePrefix + "-" + androidUuid + "-" + tableName + "-" + timestamp + ".xml";
        if(exportedIDs.size() > 0 && writeToFile(xmlString, xmlFileName)) exportCount++;
        Log.i(LOG_TAG, "exporting table complete: " + tableName);
        //String xmlString = xmlBuilder.end();
        //if(!c.isClosed()) c.close();
        //String xmlFileName = exportFileNamePrefix + ".xml";
        //boolean exported = writeToFile(xmlString, xmlFileName);
        Log.i(LOG_TAG, "exporting database complete");
        return exportCount;
    }

    private void setDataExported(String tableName, ArrayList<Long> exportedIDs) {
        if(exportedIDs.size() < 1) return;

        String sqlUpdate = "UPDATE " + tableName;
        sqlUpdate += " SET ready_to_export = '" + Boolean.FALSE.toString() + "'";
        sqlUpdate += " WHERE ";

        long id = -1;
        for(int i = 0; i < exportedIDs.size(); i++) {
            id = exportedIDs.get(i);
            sqlUpdate += "_id=" + id;
            if(i < exportedIDs.size() - 1) {
                sqlUpdate += " OR ";
            }
        }
        db.execSQL(sqlUpdate);
        Log.i(LOG_TAG, "Table data set to exported: " + tableName);
    }

    private ArrayList<Long> exportTable(final String tableName) throws IOException {
        xmlBuilder.openTable(tableName);
        String sql = "select * from " + tableName;
        sql += " where ready_to_export='" + Boolean.TRUE.toString() + "'";
        Cursor c = db.rawQuery(sql, new String[0]);
        ArrayList<Long> exportedIDs = new ArrayList<Long>();
        if (c.moveToFirst()) {
            int cols = c.getColumnCount();
            do {
                long id = c.getLong(c.getColumnIndex("_id"));
                if(id != -1) exportedIDs.add(id);
                xmlBuilder.openRow();
                for (int i = 0; i < cols; i++) {
                    xmlBuilder.addColumn(c.getColumnName(i), c.getString(i));
                }
                xmlBuilder.closeRow();
            } while (c.moveToNext());
        }
        c.close();
        xmlBuilder.closeTable();
        return exportedIDs;
    }

    private ArrayList<Long> exportWholeTable(final String tableName) throws IOException {
        xmlBuilder.openTable(tableName);
        String sql = "select * from " + tableName;
        Cursor c = db.rawQuery(sql, new String[0]);
        ArrayList<Long> exportedIDs = new ArrayList<Long>();
        if (c.moveToFirst()) {
            int cols = c.getColumnCount();
            do {
                long id = c.getLong(c.getColumnIndex("_id"));
                if(id != -1) exportedIDs.add(id);
                xmlBuilder.openRow();
                for (int i = 0; i < cols; i++) {
                    xmlBuilder.addColumn(c.getColumnName(i), c.getString(i));
                }
                xmlBuilder.closeRow();
            } while (c.moveToNext());
        }
        c.close();
        xmlBuilder.closeTable();
        return exportedIDs;
    }

    private boolean writeToFile(final String xmlString, final String exportFileName) throws IOException {
        boolean exportSuccess = true;
        File dir = FTSUtilities.getFileDirectory(""); //new File(Environment.getExternalStorageDirectory(), DataXMLExporter.DATASUBDIRECTORY);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File file = new File(dir, exportFileName);
        file.createNewFile();

        ByteBuffer buff = ByteBuffer.wrap(xmlString.getBytes());
        FileChannel channel = new FileOutputStream(file).getChannel();
        try {
            channel.write(buff);
            Log.e(LOG_TAG, "File written: " + exportFileName);
        } catch (Exception e) {
            Log.e(LOG_TAG, "File NOT written: " + exportFileName);
            e.printStackTrace();
            exportSuccess = false;
        } finally {
            if (channel != null) {
                channel.close();
            }
        }

        return exportSuccess;
    }

    /**
     * XmlBuilder is used to write XML tags (open and close, and a few attributes)
     * to a StringBuilder. Here we have nothing to do with IO or SQL, just a fancy StringBuilder.
     *
     * @author ccollins
     *
     */
    /*static class XmlBuilder {
        private static final String OPEN_XML_STANZA = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
        private static final String OPEN = "<";
        private static final String CLOSE = ">";
        private static final String CLOSE_START = "</";
        private static final String CLOSE_WITH_TICK = "'>";
        private static final String DB_OPEN = "<database name='";
        private static final String DB_CLOSE = "</database>";
        private static final String TABLE_OPEN = "<table name='";
        private static final String TABLE_CLOSE = "</table>";
        private static final String ROW_OPEN = "<row>";
        private static final String ROW_CLOSE = "</row>";
        private static final String COL_OPEN = "<col name='";
        private static final String COL_CLOSE = "</col>";

        private final StringBuilder sb;

        public XmlBuilder() throws IOException {
            sb = new StringBuilder();
        }

        void start(final String dbName) {
            sb.append(XmlBuilder.OPEN_XML_STANZA);
            sb.append(XmlBuilder.DB_OPEN + dbName + XmlBuilder.CLOSE_WITH_TICK);
        }

        String end() throws IOException {
            sb.append(XmlBuilder.DB_CLOSE);
            return sb.toString();
        }

        void openTable(final String tableName) {
            sb.append(XmlBuilder.TABLE_OPEN + tableName + XmlBuilder.CLOSE_WITH_TICK);
        }

        void closeTable() {
            sb.append(XmlBuilder.TABLE_CLOSE);
        }

        void openRow() {
            sb.append(XmlBuilder.ROW_OPEN);
        }

        void closeRow() {
            sb.append(XmlBuilder.ROW_CLOSE);
        }

        void addColumn(final String name, final String val) throws IOException {
            sb.append(XmlBuilder.OPEN + name + XmlBuilder.CLOSE + val + XmlBuilder.CLOSE_START + name + XmlBuilder.CLOSE);
        }
    }

}
*/
}
