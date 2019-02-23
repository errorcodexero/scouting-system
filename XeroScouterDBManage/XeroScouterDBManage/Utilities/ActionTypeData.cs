using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace XeroScouterDBManage_Server.Utilities
{
    class ActionTypeData
    {
        private Dictionary<String, Int32> dictActionTypes;
        private Dictionary<Int32, String> dictActionTypeIDs;
        private Dictionary<Control, String> dictActionTypeControls;
        private Dictionary<String, Control> dictActionTypeNames;

        Int32 actionTypeId; //action_type_id
        String actionTypeName;
        Control actionTypeControl;
    }
}
