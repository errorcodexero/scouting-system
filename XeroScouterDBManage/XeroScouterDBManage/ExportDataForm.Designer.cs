namespace XeroScouterDBManage_Server
{
    partial class ExportDataForm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(ExportDataForm));
            this.btnClose = new System.Windows.Forms.Button();
            this.cmbCompetitionName = new System.Windows.Forms.ComboBox();
            this.lblCompetitionName = new System.Windows.Forms.Label();
            this.lblExportData = new System.Windows.Forms.Label();
            this.lblStatus = new System.Windows.Forms.Label();
            this.chkTableList = new System.Windows.Forms.CheckedListBox();
            this.btnExportSelected = new System.Windows.Forms.Button();
            this.btnExportAll = new System.Windows.Forms.Button();
            this.folderBrowserDialog1 = new System.Windows.Forms.FolderBrowserDialog();
            this.lblPath = new System.Windows.Forms.Label();
            this.btnSetPath = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // btnClose
            // 
            this.btnClose.Anchor = System.Windows.Forms.AnchorStyles.Right;
            this.btnClose.DialogResult = System.Windows.Forms.DialogResult.Cancel;
            this.btnClose.Location = new System.Drawing.Point(281, 185);
            this.btnClose.Name = "btnClose";
            this.btnClose.RightToLeft = System.Windows.Forms.RightToLeft.No;
            this.btnClose.Size = new System.Drawing.Size(104, 37);
            this.btnClose.TabIndex = 13;
            this.btnClose.Text = "&Close";
            this.btnClose.UseVisualStyleBackColor = true;
            this.btnClose.Click += new System.EventHandler(this.btnClose_Click);
            // 
            // cmbCompetitionName
            // 
            this.cmbCompetitionName.FormattingEnabled = true;
            this.cmbCompetitionName.Location = new System.Drawing.Point(115, 68);
            this.cmbCompetitionName.Name = "cmbCompetitionName";
            this.cmbCompetitionName.Size = new System.Drawing.Size(121, 21);
            this.cmbCompetitionName.TabIndex = 19;
            // 
            // lblCompetitionName
            // 
            this.lblCompetitionName.AutoSize = true;
            this.lblCompetitionName.Location = new System.Drawing.Point(16, 71);
            this.lblCompetitionName.Name = "lblCompetitionName";
            this.lblCompetitionName.Size = new System.Drawing.Size(93, 13);
            this.lblCompetitionName.TabIndex = 18;
            this.lblCompetitionName.Text = "Competition Name";
            // 
            // lblExportData
            // 
            this.lblExportData.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.lblExportData.AutoSize = true;
            this.lblExportData.Font = new System.Drawing.Font("Microsoft Sans Serif", 18F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblExportData.Location = new System.Drawing.Point(130, 9);
            this.lblExportData.Name = "lblExportData";
            this.lblExportData.Size = new System.Drawing.Size(137, 29);
            this.lblExportData.TabIndex = 17;
            this.lblExportData.Text = "Export Data";
            this.lblExportData.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // lblStatus
            // 
            this.lblStatus.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
            this.lblStatus.AutoSize = true;
            this.lblStatus.Enabled = false;
            this.lblStatus.Location = new System.Drawing.Point(12, 267);
            this.lblStatus.Name = "lblStatus";
            this.lblStatus.Size = new System.Drawing.Size(0, 13);
            this.lblStatus.TabIndex = 20;
            this.lblStatus.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            // 
            // chkTableList
            // 
            this.chkTableList.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.chkTableList.FormattingEnabled = true;
            this.chkTableList.Location = new System.Drawing.Point(116, 99);
            this.chkTableList.Name = "chkTableList";
            this.chkTableList.Size = new System.Drawing.Size(120, 124);
            this.chkTableList.TabIndex = 21;
            this.chkTableList.ThreeDCheckBoxes = true;
            // 
            // btnExportSelected
            // 
            this.btnExportSelected.Anchor = System.Windows.Forms.AnchorStyles.Right;
            this.btnExportSelected.Location = new System.Drawing.Point(281, 126);
            this.btnExportSelected.Name = "btnExportSelected";
            this.btnExportSelected.RightToLeft = System.Windows.Forms.RightToLeft.No;
            this.btnExportSelected.Size = new System.Drawing.Size(104, 37);
            this.btnExportSelected.TabIndex = 13;
            this.btnExportSelected.Text = "Export &Selected";
            this.btnExportSelected.UseVisualStyleBackColor = true;
            this.btnExportSelected.Click += new System.EventHandler(this.btnExportSelected_Click);
            // 
            // btnExportAll
            // 
            this.btnExportAll.Anchor = System.Windows.Forms.AnchorStyles.Right;
            this.btnExportAll.Location = new System.Drawing.Point(281, 68);
            this.btnExportAll.Name = "btnExportAll";
            this.btnExportAll.RightToLeft = System.Windows.Forms.RightToLeft.No;
            this.btnExportAll.Size = new System.Drawing.Size(104, 37);
            this.btnExportAll.TabIndex = 13;
            this.btnExportAll.Text = "Export &All";
            this.btnExportAll.UseVisualStyleBackColor = true;
            this.btnExportAll.Click += new System.EventHandler(this.btnExportAll_Click);
            // 
            // folderBrowserDialog1
            // 
            this.folderBrowserDialog1.Description = "Select the folder to export";
            this.folderBrowserDialog1.SelectedPath = "C:\\";
            this.folderBrowserDialog1.ShowNewFolderButton = false;
            // 
            // lblPath
            // 
            this.lblPath.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
            this.lblPath.AutoSize = true;
            this.lblPath.Location = new System.Drawing.Point(86, 245);
            this.lblPath.Name = "lblPath";
            this.lblPath.Size = new System.Drawing.Size(0, 13);
            this.lblPath.TabIndex = 22;
            // 
            // btnSetPath
            // 
            this.btnSetPath.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
            this.btnSetPath.Location = new System.Drawing.Point(12, 235);
            this.btnSetPath.Name = "btnSetPath";
            this.btnSetPath.RightToLeft = System.Windows.Forms.RightToLeft.No;
            this.btnSetPath.Size = new System.Drawing.Size(57, 28);
            this.btnSetPath.TabIndex = 13;
            this.btnSetPath.Text = "Set Path";
            this.btnSetPath.UseVisualStyleBackColor = true;
            this.btnSetPath.Click += new System.EventHandler(this.btnSetPath_Click);
            // 
            // ExportDataForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.CancelButton = this.btnClose;
            this.ClientSize = new System.Drawing.Size(395, 268);
            this.Controls.Add(this.lblPath);
            this.Controls.Add(this.chkTableList);
            this.Controls.Add(this.lblStatus);
            this.Controls.Add(this.cmbCompetitionName);
            this.Controls.Add(this.lblCompetitionName);
            this.Controls.Add(this.lblExportData);
            this.Controls.Add(this.btnExportAll);
            this.Controls.Add(this.btnExportSelected);
            this.Controls.Add(this.btnSetPath);
            this.Controls.Add(this.btnClose);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "ExportDataForm";
            this.Text = "frmExportData";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button btnClose;
        private System.Windows.Forms.ComboBox cmbCompetitionName;
        private System.Windows.Forms.Label lblCompetitionName;
        private System.Windows.Forms.Label lblExportData;
        private System.Windows.Forms.Label lblStatus;
        private System.Windows.Forms.CheckedListBox chkTableList;
        private System.Windows.Forms.Button btnExportSelected;
        private System.Windows.Forms.Button btnExportAll;
        private System.Windows.Forms.FolderBrowserDialog folderBrowserDialog1;
        private System.Windows.Forms.Label lblPath;
        private System.Windows.Forms.Button btnSetPath;
    }
}