namespace XeroScouterDBManage_Server
{
    partial class ImportDataForm
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(ImportDataForm));
            this.lblStatus = new System.Windows.Forms.Label();
            this.cmbCompetitionName = new System.Windows.Forms.ComboBox();
            this.lblCompetitionName = new System.Windows.Forms.Label();
            this.lblImportData = new System.Windows.Forms.Label();
            this.lblPath = new System.Windows.Forms.Label();
            this.btnSetPath = new System.Windows.Forms.Button();
            this.chkFileList = new System.Windows.Forms.CheckedListBox();
            this.folderBrowserDialog1 = new System.Windows.Forms.FolderBrowserDialog();
            this.btnImportAll = new System.Windows.Forms.Button();
            this.btnImportSelected = new System.Windows.Forms.Button();
            this.btnClose = new System.Windows.Forms.Button();
            this.btnIgnoreSelected = new System.Windows.Forms.Button();
            this.btnIgnoreAll = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // lblStatus
            // 
            this.lblStatus.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.lblStatus.AutoSize = true;
            this.lblStatus.Enabled = false;
            this.lblStatus.Location = new System.Drawing.Point(19, 246);
            this.lblStatus.Name = "lblStatus";
            this.lblStatus.Size = new System.Drawing.Size(0, 13);
            this.lblStatus.TabIndex = 24;
            this.lblStatus.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
            // 
            // cmbCompetitionName
            // 
            this.cmbCompetitionName.FormattingEnabled = true;
            this.cmbCompetitionName.Location = new System.Drawing.Point(117, 54);
            this.cmbCompetitionName.Name = "cmbCompetitionName";
            this.cmbCompetitionName.Size = new System.Drawing.Size(121, 21);
            this.cmbCompetitionName.TabIndex = 23;
            // 
            // lblCompetitionName
            // 
            this.lblCompetitionName.AutoSize = true;
            this.lblCompetitionName.Location = new System.Drawing.Point(18, 57);
            this.lblCompetitionName.Name = "lblCompetitionName";
            this.lblCompetitionName.Size = new System.Drawing.Size(93, 13);
            this.lblCompetitionName.TabIndex = 22;
            this.lblCompetitionName.Text = "Competition Name";
            // 
            // lblImportData
            // 
            this.lblImportData.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.lblImportData.AutoSize = true;
            this.lblImportData.Font = new System.Drawing.Font("Microsoft Sans Serif", 18F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblImportData.Location = new System.Drawing.Point(137, 9);
            this.lblImportData.Name = "lblImportData";
            this.lblImportData.Size = new System.Drawing.Size(136, 29);
            this.lblImportData.TabIndex = 21;
            this.lblImportData.Text = "Import Data";
            this.lblImportData.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // lblPath
            // 
            this.lblPath.AutoSize = true;
            this.lblPath.Location = new System.Drawing.Point(72, 212);
            this.lblPath.Name = "lblPath";
            this.lblPath.Size = new System.Drawing.Size(28, 13);
            this.lblPath.TabIndex = 26;
            this.lblPath.Text = "path";
            // 
            // btnSetPath
            // 
            this.btnSetPath.Location = new System.Drawing.Point(12, 200);
            this.btnSetPath.Name = "btnSetPath";
            this.btnSetPath.RightToLeft = System.Windows.Forms.RightToLeft.No;
            this.btnSetPath.Size = new System.Drawing.Size(47, 37);
            this.btnSetPath.TabIndex = 25;
            this.btnSetPath.Text = "Set Path";
            this.btnSetPath.UseVisualStyleBackColor = true;
            this.btnSetPath.Click += new System.EventHandler(this.btnSetPath_Click);
            // 
            // chkFileList
            // 
            this.chkFileList.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.chkFileList.CheckOnClick = true;
            this.chkFileList.FormattingEnabled = true;
            this.chkFileList.HorizontalExtent = 10;
            this.chkFileList.HorizontalScrollbar = true;
            this.chkFileList.Location = new System.Drawing.Point(23, 87);
            this.chkFileList.Name = "chkFileList";
            this.chkFileList.Size = new System.Drawing.Size(249, 94);
            this.chkFileList.TabIndex = 27;
            this.chkFileList.ThreeDCheckBoxes = true;
            // 
            // btnImportAll
            // 
            this.btnImportAll.Anchor = System.Windows.Forms.AnchorStyles.Right;
            this.btnImportAll.Location = new System.Drawing.Point(279, 45);
            this.btnImportAll.Name = "btnImportAll";
            this.btnImportAll.RightToLeft = System.Windows.Forms.RightToLeft.No;
            this.btnImportAll.Size = new System.Drawing.Size(104, 37);
            this.btnImportAll.TabIndex = 30;
            this.btnImportAll.Text = "Import &All";
            this.btnImportAll.UseVisualStyleBackColor = true;
            this.btnImportAll.Click += new System.EventHandler(this.btnImportAll_Click);
            // 
            // btnImportSelected
            // 
            this.btnImportSelected.Anchor = System.Windows.Forms.AnchorStyles.Right;
            this.btnImportSelected.Location = new System.Drawing.Point(279, 88);
            this.btnImportSelected.Name = "btnImportSelected";
            this.btnImportSelected.RightToLeft = System.Windows.Forms.RightToLeft.No;
            this.btnImportSelected.Size = new System.Drawing.Size(104, 37);
            this.btnImportSelected.TabIndex = 29;
            this.btnImportSelected.Text = "Import &Selected";
            this.btnImportSelected.UseVisualStyleBackColor = true;
            this.btnImportSelected.Click += new System.EventHandler(this.btnImportSelected_Click);
            // 
            // btnClose
            // 
            this.btnClose.Anchor = System.Windows.Forms.AnchorStyles.Right;
            this.btnClose.Location = new System.Drawing.Point(279, 212);
            this.btnClose.Name = "btnClose";
            this.btnClose.RightToLeft = System.Windows.Forms.RightToLeft.No;
            this.btnClose.Size = new System.Drawing.Size(104, 37);
            this.btnClose.TabIndex = 28;
            this.btnClose.Text = "&Close";
            this.btnClose.UseVisualStyleBackColor = true;
            this.btnClose.Click += new System.EventHandler(this.btnClose_Click);
            // 
            // btnIgnoreSelected
            // 
            this.btnIgnoreSelected.Anchor = System.Windows.Forms.AnchorStyles.Right;
            this.btnIgnoreSelected.Location = new System.Drawing.Point(279, 174);
            this.btnIgnoreSelected.Name = "btnIgnoreSelected";
            this.btnIgnoreSelected.RightToLeft = System.Windows.Forms.RightToLeft.No;
            this.btnIgnoreSelected.Size = new System.Drawing.Size(104, 32);
            this.btnIgnoreSelected.TabIndex = 29;
            this.btnIgnoreSelected.Text = "Ignore S&elected";
            this.btnIgnoreSelected.UseVisualStyleBackColor = true;
            this.btnIgnoreSelected.Click += new System.EventHandler(this.btnIgnoreSelected_Click);
            // 
            // btnIgnoreAll
            // 
            this.btnIgnoreAll.Anchor = System.Windows.Forms.AnchorStyles.Right;
            this.btnIgnoreAll.Location = new System.Drawing.Point(279, 136);
            this.btnIgnoreAll.Name = "btnIgnoreAll";
            this.btnIgnoreAll.RightToLeft = System.Windows.Forms.RightToLeft.No;
            this.btnIgnoreAll.Size = new System.Drawing.Size(104, 32);
            this.btnIgnoreAll.TabIndex = 29;
            this.btnIgnoreAll.Text = "Ignore A&ll";
            this.btnIgnoreAll.UseVisualStyleBackColor = true;
            this.btnIgnoreAll.Click += new System.EventHandler(this.btnIgnoreAll_Click);
            // 
            // ImportDataForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(395, 271);
            this.Controls.Add(this.btnImportAll);
            this.Controls.Add(this.btnIgnoreAll);
            this.Controls.Add(this.btnIgnoreSelected);
            this.Controls.Add(this.btnImportSelected);
            this.Controls.Add(this.btnClose);
            this.Controls.Add(this.chkFileList);
            this.Controls.Add(this.lblPath);
            this.Controls.Add(this.btnSetPath);
            this.Controls.Add(this.lblStatus);
            this.Controls.Add(this.cmbCompetitionName);
            this.Controls.Add(this.lblCompetitionName);
            this.Controls.Add(this.lblImportData);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "ImportDataForm";
            this.Text = "ImportDataForm";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lblStatus;
        private System.Windows.Forms.ComboBox cmbCompetitionName;
        private System.Windows.Forms.Label lblCompetitionName;
        private System.Windows.Forms.Label lblImportData;
        private System.Windows.Forms.Label lblPath;
        private System.Windows.Forms.Button btnSetPath;
        private System.Windows.Forms.CheckedListBox chkFileList;
        private System.Windows.Forms.FolderBrowserDialog folderBrowserDialog1;
        private System.Windows.Forms.Button btnImportAll;
        private System.Windows.Forms.Button btnImportSelected;
        private System.Windows.Forms.Button btnClose;
        private System.Windows.Forms.Button btnIgnoreSelected;
        private System.Windows.Forms.Button btnIgnoreAll;
    }
}