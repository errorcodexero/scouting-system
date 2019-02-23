namespace XeroScouterDBManage_Server
{
    partial class AddMatchForm
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(AddMatchForm));
            this.lblMatchNumber = new System.Windows.Forms.Label();
            this.txtMatchNumber = new System.Windows.Forms.TextBox();
            this.txtMatchTime = new System.Windows.Forms.TextBox();
            this.lblMatchTime = new System.Windows.Forms.Label();
            this.txtMatchType = new System.Windows.Forms.TextBox();
            this.lblMatchType = new System.Windows.Forms.Label();
            this.txtMatchLocation = new System.Windows.Forms.TextBox();
            this.lblMatchLocation = new System.Windows.Forms.Label();
            this.lblBlueAlliance = new System.Windows.Forms.Label();
            this.lblRedAlliance = new System.Windows.Forms.Label();
            this.cmbBlue1 = new System.Windows.Forms.ComboBox();
            this.cmbBlue2 = new System.Windows.Forms.ComboBox();
            this.cmbBlue3 = new System.Windows.Forms.ComboBox();
            this.cmbRed1 = new System.Windows.Forms.ComboBox();
            this.cmbRed2 = new System.Windows.Forms.ComboBox();
            this.cmbRed3 = new System.Windows.Forms.ComboBox();
            this.btnSave = new System.Windows.Forms.Button();
            this.btnSaveAndAddNew = new System.Windows.Forms.Button();
            this.btnCancel = new System.Windows.Forms.Button();
            this.lblStatus = new System.Windows.Forms.Label();
            this.cmbCompetitionName = new System.Windows.Forms.ComboBox();
            this.lblCompetitionName = new System.Windows.Forms.Label();
            this.lblAddAMatch = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // lblMatchNumber
            // 
            this.lblMatchNumber.AutoSize = true;
            this.lblMatchNumber.Location = new System.Drawing.Point(12, 120);
            this.lblMatchNumber.Name = "lblMatchNumber";
            this.lblMatchNumber.Size = new System.Drawing.Size(77, 13);
            this.lblMatchNumber.TabIndex = 0;
            this.lblMatchNumber.Text = "Match Number";
            // 
            // txtMatchNumber
            // 
            this.txtMatchNumber.Location = new System.Drawing.Point(105, 116);
            this.txtMatchNumber.Name = "txtMatchNumber";
            this.txtMatchNumber.Size = new System.Drawing.Size(80, 20);
            this.txtMatchNumber.TabIndex = 0;
            this.txtMatchNumber.TextChanged += new System.EventHandler(this.txtMatchNumber_TextChanged);
            // 
            // txtMatchTime
            // 
            this.txtMatchTime.Location = new System.Drawing.Point(105, 154);
            this.txtMatchTime.Name = "txtMatchTime";
            this.txtMatchTime.Size = new System.Drawing.Size(80, 20);
            this.txtMatchTime.TabIndex = 2;
            this.txtMatchTime.TextChanged += new System.EventHandler(this.txtMatchTime_TextChanged);
            // 
            // lblMatchTime
            // 
            this.lblMatchTime.AutoSize = true;
            this.lblMatchTime.Location = new System.Drawing.Point(12, 158);
            this.lblMatchTime.Name = "lblMatchTime";
            this.lblMatchTime.Size = new System.Drawing.Size(63, 13);
            this.lblMatchTime.TabIndex = 2;
            this.lblMatchTime.Text = "Match Time";
            // 
            // txtMatchType
            // 
            this.txtMatchType.Location = new System.Drawing.Point(292, 116);
            this.txtMatchType.Name = "txtMatchType";
            this.txtMatchType.Size = new System.Drawing.Size(152, 20);
            this.txtMatchType.TabIndex = 1;
            this.txtMatchType.Text = "Qualification";
            this.txtMatchType.TextChanged += new System.EventHandler(this.txtMatchType_TextChanged);
            // 
            // lblMatchType
            // 
            this.lblMatchType.AutoSize = true;
            this.lblMatchType.Location = new System.Drawing.Point(206, 120);
            this.lblMatchType.Name = "lblMatchType";
            this.lblMatchType.Size = new System.Drawing.Size(64, 13);
            this.lblMatchType.TabIndex = 4;
            this.lblMatchType.Text = "Match Type";
            // 
            // txtMatchLocation
            // 
            this.txtMatchLocation.Location = new System.Drawing.Point(292, 154);
            this.txtMatchLocation.Name = "txtMatchLocation";
            this.txtMatchLocation.Size = new System.Drawing.Size(152, 20);
            this.txtMatchLocation.TabIndex = 3;
            this.txtMatchLocation.TextChanged += new System.EventHandler(this.txtMatchLocation_TextChanged);
            // 
            // lblMatchLocation
            // 
            this.lblMatchLocation.AutoSize = true;
            this.lblMatchLocation.Location = new System.Drawing.Point(206, 158);
            this.lblMatchLocation.Name = "lblMatchLocation";
            this.lblMatchLocation.Size = new System.Drawing.Size(81, 13);
            this.lblMatchLocation.TabIndex = 6;
            this.lblMatchLocation.Text = "Match Location";
            // 
            // lblBlueAlliance
            // 
            this.lblBlueAlliance.AutoSize = true;
            this.lblBlueAlliance.Location = new System.Drawing.Point(107, 206);
            this.lblBlueAlliance.Name = "lblBlueAlliance";
            this.lblBlueAlliance.Size = new System.Drawing.Size(68, 13);
            this.lblBlueAlliance.TabIndex = 8;
            this.lblBlueAlliance.Text = "Blue Alliance";
            // 
            // lblRedAlliance
            // 
            this.lblRedAlliance.AutoSize = true;
            this.lblRedAlliance.Location = new System.Drawing.Point(285, 206);
            this.lblRedAlliance.Name = "lblRedAlliance";
            this.lblRedAlliance.Size = new System.Drawing.Size(67, 13);
            this.lblRedAlliance.TabIndex = 9;
            this.lblRedAlliance.Text = "Red Alliance";
            // 
            // cmbBlue1
            // 
            this.cmbBlue1.AutoCompleteMode = System.Windows.Forms.AutoCompleteMode.Append;
            this.cmbBlue1.AutoCompleteSource = System.Windows.Forms.AutoCompleteSource.ListItems;
            this.cmbBlue1.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cmbBlue1.FormattingEnabled = true;
            this.cmbBlue1.Location = new System.Drawing.Point(78, 230);
            this.cmbBlue1.Name = "cmbBlue1";
            this.cmbBlue1.Size = new System.Drawing.Size(121, 21);
            this.cmbBlue1.TabIndex = 4;
            this.cmbBlue1.SelectedIndexChanged += new System.EventHandler(this.cmbBlue1_SelectedIndexChanged);
            // 
            // cmbBlue2
            // 
            this.cmbBlue2.AutoCompleteMode = System.Windows.Forms.AutoCompleteMode.Append;
            this.cmbBlue2.AutoCompleteSource = System.Windows.Forms.AutoCompleteSource.ListItems;
            this.cmbBlue2.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cmbBlue2.FormattingEnabled = true;
            this.cmbBlue2.Location = new System.Drawing.Point(78, 264);
            this.cmbBlue2.Name = "cmbBlue2";
            this.cmbBlue2.Size = new System.Drawing.Size(121, 21);
            this.cmbBlue2.TabIndex = 5;
            this.cmbBlue2.SelectedIndexChanged += new System.EventHandler(this.cmbBlue2_SelectedIndexChanged);
            // 
            // cmbBlue3
            // 
            this.cmbBlue3.AutoCompleteMode = System.Windows.Forms.AutoCompleteMode.Append;
            this.cmbBlue3.AutoCompleteSource = System.Windows.Forms.AutoCompleteSource.ListItems;
            this.cmbBlue3.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cmbBlue3.FormattingEnabled = true;
            this.cmbBlue3.Location = new System.Drawing.Point(78, 297);
            this.cmbBlue3.Name = "cmbBlue3";
            this.cmbBlue3.Size = new System.Drawing.Size(121, 21);
            this.cmbBlue3.TabIndex = 6;
            this.cmbBlue3.SelectedIndexChanged += new System.EventHandler(this.cmbBlue3_SelectedIndexChanged);
            // 
            // cmbRed1
            // 
            this.cmbRed1.AutoCompleteMode = System.Windows.Forms.AutoCompleteMode.Append;
            this.cmbRed1.AutoCompleteSource = System.Windows.Forms.AutoCompleteSource.ListItems;
            this.cmbRed1.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cmbRed1.FormattingEnabled = true;
            this.cmbRed1.Location = new System.Drawing.Point(259, 230);
            this.cmbRed1.Name = "cmbRed1";
            this.cmbRed1.Size = new System.Drawing.Size(121, 21);
            this.cmbRed1.TabIndex = 7;
            this.cmbRed1.SelectedIndexChanged += new System.EventHandler(this.cmbRed1_SelectedIndexChanged);
            // 
            // cmbRed2
            // 
            this.cmbRed2.AutoCompleteMode = System.Windows.Forms.AutoCompleteMode.Append;
            this.cmbRed2.AutoCompleteSource = System.Windows.Forms.AutoCompleteSource.ListItems;
            this.cmbRed2.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cmbRed2.FormattingEnabled = true;
            this.cmbRed2.Location = new System.Drawing.Point(259, 264);
            this.cmbRed2.Name = "cmbRed2";
            this.cmbRed2.Size = new System.Drawing.Size(121, 21);
            this.cmbRed2.TabIndex = 8;
            this.cmbRed2.SelectedIndexChanged += new System.EventHandler(this.cmbRed2_SelectedIndexChanged);
            // 
            // cmbRed3
            // 
            this.cmbRed3.AutoCompleteMode = System.Windows.Forms.AutoCompleteMode.Append;
            this.cmbRed3.AutoCompleteSource = System.Windows.Forms.AutoCompleteSource.ListItems;
            this.cmbRed3.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cmbRed3.FormattingEnabled = true;
            this.cmbRed3.Location = new System.Drawing.Point(259, 297);
            this.cmbRed3.Name = "cmbRed3";
            this.cmbRed3.Size = new System.Drawing.Size(121, 21);
            this.cmbRed3.TabIndex = 9;
            this.cmbRed3.SelectedIndexChanged += new System.EventHandler(this.cmbRed3_SelectedIndexChanged);
            // 
            // btnSave
            // 
            this.btnSave.Location = new System.Drawing.Point(33, 354);
            this.btnSave.Name = "btnSave";
            this.btnSave.Size = new System.Drawing.Size(102, 41);
            this.btnSave.TabIndex = 10;
            this.btnSave.Text = "&Save && Exit";
            this.btnSave.UseVisualStyleBackColor = true;
            this.btnSave.Click += new System.EventHandler(this.btnSave_Click);
            // 
            // btnSaveAndAddNew
            // 
            this.btnSaveAndAddNew.Location = new System.Drawing.Point(170, 354);
            this.btnSaveAndAddNew.Name = "btnSaveAndAddNew";
            this.btnSaveAndAddNew.Size = new System.Drawing.Size(102, 41);
            this.btnSaveAndAddNew.TabIndex = 11;
            this.btnSaveAndAddNew.Text = "Save && &Add New";
            this.btnSaveAndAddNew.UseVisualStyleBackColor = true;
            this.btnSaveAndAddNew.Click += new System.EventHandler(this.btnSaveAndAddNew_Click);
            // 
            // btnCancel
            // 
            this.btnCancel.Location = new System.Drawing.Point(308, 354);
            this.btnCancel.Name = "btnCancel";
            this.btnCancel.Size = new System.Drawing.Size(102, 41);
            this.btnCancel.TabIndex = 12;
            this.btnCancel.Text = "&Cancel";
            this.btnCancel.UseVisualStyleBackColor = true;
            this.btnCancel.Click += new System.EventHandler(this.btnCancel_Click);
            // 
            // lblStatus
            // 
            this.lblStatus.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.lblStatus.AutoSize = true;
            this.lblStatus.Location = new System.Drawing.Point(4, 412);
            this.lblStatus.Name = "lblStatus";
            this.lblStatus.Size = new System.Drawing.Size(35, 13);
            this.lblStatus.TabIndex = 13;
            this.lblStatus.Text = "status";
            this.lblStatus.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // cmbCompetitionName
            // 
            this.cmbCompetitionName.FormattingEnabled = true;
            this.cmbCompetitionName.Location = new System.Drawing.Point(105, 63);
            this.cmbCompetitionName.Name = "cmbCompetitionName";
            this.cmbCompetitionName.Size = new System.Drawing.Size(339, 21);
            this.cmbCompetitionName.TabIndex = 21;
            this.cmbCompetitionName.SelectedValueChanged += new System.EventHandler(this.cmbCompetitionName_SelectedValueChanged);
            // 
            // lblCompetitionName
            // 
            this.lblCompetitionName.AutoSize = true;
            this.lblCompetitionName.Location = new System.Drawing.Point(12, 66);
            this.lblCompetitionName.Name = "lblCompetitionName";
            this.lblCompetitionName.Size = new System.Drawing.Size(62, 13);
            this.lblCompetitionName.TabIndex = 20;
            this.lblCompetitionName.Text = "Competition";
            // 
            // lblAddAMatch
            // 
            this.lblAddAMatch.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.lblAddAMatch.AutoSize = true;
            this.lblAddAMatch.Font = new System.Drawing.Font("Microsoft Sans Serif", 18F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblAddAMatch.Location = new System.Drawing.Point(156, 9);
            this.lblAddAMatch.Name = "lblAddAMatch";
            this.lblAddAMatch.Size = new System.Drawing.Size(147, 29);
            this.lblAddAMatch.TabIndex = 22;
            this.lblAddAMatch.Text = "Add A Match";
            this.lblAddAMatch.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // AddMatchForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(465, 431);
            this.Controls.Add(this.lblAddAMatch);
            this.Controls.Add(this.cmbCompetitionName);
            this.Controls.Add(this.lblCompetitionName);
            this.Controls.Add(this.lblStatus);
            this.Controls.Add(this.btnCancel);
            this.Controls.Add(this.btnSaveAndAddNew);
            this.Controls.Add(this.btnSave);
            this.Controls.Add(this.cmbRed3);
            this.Controls.Add(this.cmbRed2);
            this.Controls.Add(this.cmbBlue3);
            this.Controls.Add(this.cmbRed1);
            this.Controls.Add(this.cmbBlue2);
            this.Controls.Add(this.cmbBlue1);
            this.Controls.Add(this.lblRedAlliance);
            this.Controls.Add(this.lblBlueAlliance);
            this.Controls.Add(this.txtMatchLocation);
            this.Controls.Add(this.lblMatchLocation);
            this.Controls.Add(this.txtMatchType);
            this.Controls.Add(this.lblMatchType);
            this.Controls.Add(this.txtMatchTime);
            this.Controls.Add(this.lblMatchTime);
            this.Controls.Add(this.txtMatchNumber);
            this.Controls.Add(this.lblMatchNumber);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "AddMatchForm";
            this.Text = "AddMatchForm";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lblMatchNumber;
        private System.Windows.Forms.TextBox txtMatchNumber;
        private System.Windows.Forms.TextBox txtMatchTime;
        private System.Windows.Forms.Label lblMatchTime;
        private System.Windows.Forms.TextBox txtMatchType;
        private System.Windows.Forms.Label lblMatchType;
        private System.Windows.Forms.TextBox txtMatchLocation;
        private System.Windows.Forms.Label lblMatchLocation;
        private System.Windows.Forms.Label lblBlueAlliance;
        private System.Windows.Forms.Label lblRedAlliance;
        private System.Windows.Forms.ComboBox cmbBlue1;
        private System.Windows.Forms.ComboBox cmbBlue2;
        private System.Windows.Forms.ComboBox cmbBlue3;
        private System.Windows.Forms.ComboBox cmbRed1;
        private System.Windows.Forms.ComboBox cmbRed2;
        private System.Windows.Forms.ComboBox cmbRed3;
        private System.Windows.Forms.Button btnSave;
        private System.Windows.Forms.Button btnSaveAndAddNew;
        private System.Windows.Forms.Button btnCancel;
        private System.Windows.Forms.Label lblStatus;
        private System.Windows.Forms.ComboBox cmbCompetitionName;
        private System.Windows.Forms.Label lblCompetitionName;
        private System.Windows.Forms.Label lblAddAMatch;
    }
}