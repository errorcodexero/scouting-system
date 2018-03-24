namespace XeroScouterDBManage_Server
{
    partial class CompetitionSelectForm
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
            this.lblSeason = new System.Windows.Forms.Label();
            this.btnCancel = new System.Windows.Forms.Button();
            this.btnSave = new System.Windows.Forms.Button();
            this.statusStrip1 = new System.Windows.Forms.StatusStrip();
            this.toolStripStatusLabel1 = new System.Windows.Forms.ToolStripStatusLabel();
            this.sslblStatus = new System.Windows.Forms.ToolStripStatusLabel();
            this.cmbCompetitionName = new System.Windows.Forms.ComboBox();
            this.lblCompetitionName = new System.Windows.Forms.Label();
            this.lblDefinitionFile = new System.Windows.Forms.Label();
            this.txtDefinitionFile = new System.Windows.Forms.TextBox();
            this.openFileDialog1 = new System.Windows.Forms.OpenFileDialog();
            this.btnSelectConfigFile = new System.Windows.Forms.Button();
            this.cmbYear = new System.Windows.Forms.ComboBox();
            this.lblYear = new System.Windows.Forms.Label();
            this.statusStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // lblSeason
            // 
            this.lblSeason.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.lblSeason.AutoSize = true;
            this.lblSeason.Font = new System.Drawing.Font("Microsoft Sans Serif", 18F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblSeason.Location = new System.Drawing.Point(150, 7);
            this.lblSeason.Name = "lblSeason";
            this.lblSeason.Size = new System.Drawing.Size(143, 29);
            this.lblSeason.TabIndex = 28;
            this.lblSeason.Text = "Competition";
            this.lblSeason.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // btnCancel
            // 
            this.btnCancel.DialogResult = System.Windows.Forms.DialogResult.Cancel;
            this.btnCancel.Location = new System.Drawing.Point(305, 183);
            this.btnCancel.Margin = new System.Windows.Forms.Padding(2);
            this.btnCancel.Name = "btnCancel";
            this.btnCancel.Size = new System.Drawing.Size(82, 30);
            this.btnCancel.TabIndex = 27;
            this.btnCancel.Text = "&Cancel";
            this.btnCancel.UseVisualStyleBackColor = true;
            this.btnCancel.Click += new System.EventHandler(this.btnCancel_Click);
            // 
            // btnSave
            // 
            this.btnSave.DialogResult = System.Windows.Forms.DialogResult.OK;
            this.btnSave.Location = new System.Drawing.Point(212, 183);
            this.btnSave.Margin = new System.Windows.Forms.Padding(2);
            this.btnSave.Name = "btnSave";
            this.btnSave.Size = new System.Drawing.Size(82, 30);
            this.btnSave.TabIndex = 26;
            this.btnSave.Text = "&Save";
            this.btnSave.UseVisualStyleBackColor = true;
            this.btnSave.Click += new System.EventHandler(this.btnSave_Click);
            // 
            // statusStrip1
            // 
            this.statusStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.toolStripStatusLabel1,
            this.sslblStatus});
            this.statusStrip1.Location = new System.Drawing.Point(0, 232);
            this.statusStrip1.Name = "statusStrip1";
            this.statusStrip1.Padding = new System.Windows.Forms.Padding(1, 0, 10, 0);
            this.statusStrip1.Size = new System.Drawing.Size(433, 22);
            this.statusStrip1.TabIndex = 25;
            this.statusStrip1.Text = "statusStrip1";
            // 
            // toolStripStatusLabel1
            // 
            this.toolStripStatusLabel1.Name = "toolStripStatusLabel1";
            this.toolStripStatusLabel1.Size = new System.Drawing.Size(39, 17);
            this.toolStripStatusLabel1.Text = "Status";
            // 
            // sslblStatus
            // 
            this.sslblStatus.Name = "sslblStatus";
            this.sslblStatus.Size = new System.Drawing.Size(0, 17);
            // 
            // cmbCompetitionName
            // 
            this.cmbCompetitionName.FormattingEnabled = true;
            this.cmbCompetitionName.Location = new System.Drawing.Point(112, 93);
            this.cmbCompetitionName.Name = "cmbCompetitionName";
            this.cmbCompetitionName.Size = new System.Drawing.Size(275, 21);
            this.cmbCompetitionName.TabIndex = 24;
            this.cmbCompetitionName.SelectedValueChanged += new System.EventHandler(this.cmbCompetitionName_SelectedValueChanged);
            // 
            // lblCompetitionName
            // 
            this.lblCompetitionName.AutoSize = true;
            this.lblCompetitionName.Location = new System.Drawing.Point(32, 95);
            this.lblCompetitionName.Name = "lblCompetitionName";
            this.lblCompetitionName.Size = new System.Drawing.Size(62, 13);
            this.lblCompetitionName.TabIndex = 23;
            this.lblCompetitionName.Text = "Competition";
            // 
            // lblDefinitionFile
            // 
            this.lblDefinitionFile.AutoSize = true;
            this.lblDefinitionFile.Location = new System.Drawing.Point(32, 133);
            this.lblDefinitionFile.Name = "lblDefinitionFile";
            this.lblDefinitionFile.Size = new System.Drawing.Size(70, 13);
            this.lblDefinitionFile.TabIndex = 29;
            this.lblDefinitionFile.Text = "Definition File";
            // 
            // txtDefinitionFile
            // 
            this.txtDefinitionFile.Location = new System.Drawing.Point(112, 130);
            this.txtDefinitionFile.Name = "txtDefinitionFile";
            this.txtDefinitionFile.ReadOnly = true;
            this.txtDefinitionFile.Size = new System.Drawing.Size(186, 20);
            this.txtDefinitionFile.TabIndex = 30;
            this.txtDefinitionFile.TextChanged += new System.EventHandler(this.txtDefinitionFile_TextChanged);
            // 
            // openFileDialog1
            // 
            this.openFileDialog1.FileName = "openFileDialog1";
            // 
            // btnSelectConfigFile
            // 
            this.btnSelectConfigFile.Location = new System.Drawing.Point(322, 127);
            this.btnSelectConfigFile.Margin = new System.Windows.Forms.Padding(2);
            this.btnSelectConfigFile.Name = "btnSelectConfigFile";
            this.btnSelectConfigFile.Size = new System.Drawing.Size(65, 25);
            this.btnSelectConfigFile.TabIndex = 27;
            this.btnSelectConfigFile.Text = "&Select";
            this.btnSelectConfigFile.UseVisualStyleBackColor = true;
            this.btnSelectConfigFile.Click += new System.EventHandler(this.btnSelectConfigFile_Click);
            // 
            // cmbYear
            // 
            this.cmbYear.FormattingEnabled = true;
            this.cmbYear.Items.AddRange(new object[] {
            "2018",
            "2017",
            "2016",
            "2015"});
            this.cmbYear.Location = new System.Drawing.Point(112, 57);
            this.cmbYear.Name = "cmbYear";
            this.cmbYear.Size = new System.Drawing.Size(275, 21);
            this.cmbYear.TabIndex = 32;
            this.cmbYear.SelectedIndexChanged += new System.EventHandler(this.cmbYear_SelectedIndexChanged);
            this.cmbYear.SelectedValueChanged += new System.EventHandler(this.cmbYear_SelectedValueChanged);
            // 
            // lblYear
            // 
            this.lblYear.AutoSize = true;
            this.lblYear.Location = new System.Drawing.Point(32, 59);
            this.lblYear.Name = "lblYear";
            this.lblYear.Size = new System.Drawing.Size(29, 13);
            this.lblYear.TabIndex = 31;
            this.lblYear.Text = "Year";
            // 
            // CompetitionSelectForm
            // 
            this.AcceptButton = this.btnSave;
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.CancelButton = this.btnCancel;
            this.ClientSize = new System.Drawing.Size(433, 254);
            this.Controls.Add(this.cmbYear);
            this.Controls.Add(this.lblYear);
            this.Controls.Add(this.txtDefinitionFile);
            this.Controls.Add(this.lblDefinitionFile);
            this.Controls.Add(this.lblSeason);
            this.Controls.Add(this.btnSelectConfigFile);
            this.Controls.Add(this.btnCancel);
            this.Controls.Add(this.btnSave);
            this.Controls.Add(this.statusStrip1);
            this.Controls.Add(this.cmbCompetitionName);
            this.Controls.Add(this.lblCompetitionName);
            this.Margin = new System.Windows.Forms.Padding(2);
            this.Name = "CompetitionSelectForm";
            this.Text = "Y";
            this.statusStrip1.ResumeLayout(false);
            this.statusStrip1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lblSeason;
        private System.Windows.Forms.Button btnCancel;
        private System.Windows.Forms.Button btnSave;
        private System.Windows.Forms.StatusStrip statusStrip1;
        private System.Windows.Forms.ToolStripStatusLabel toolStripStatusLabel1;
        private System.Windows.Forms.ToolStripStatusLabel sslblStatus;
        private System.Windows.Forms.ComboBox cmbCompetitionName;
        private System.Windows.Forms.Label lblCompetitionName;
        private System.Windows.Forms.Label lblDefinitionFile;
        private System.Windows.Forms.TextBox txtDefinitionFile;
        private System.Windows.Forms.OpenFileDialog openFileDialog1;
        private System.Windows.Forms.Button btnSelectConfigFile;
        private System.Windows.Forms.ComboBox cmbYear;
        private System.Windows.Forms.Label lblYear;
    }
}