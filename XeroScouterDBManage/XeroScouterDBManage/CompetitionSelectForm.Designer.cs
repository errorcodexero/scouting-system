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
            this.statusStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // lblSeason
            // 
            this.lblSeason.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left)
                        | System.Windows.Forms.AnchorStyles.Right)));
            this.lblSeason.AutoSize = true;
            this.lblSeason.Font = new System.Drawing.Font("Microsoft Sans Serif", 18F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblSeason.Location = new System.Drawing.Point(200, 9);
            this.lblSeason.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.lblSeason.Name = "lblSeason";
            this.lblSeason.Size = new System.Drawing.Size(173, 36);
            this.lblSeason.TabIndex = 28;
            this.lblSeason.Text = "Competition";
            this.lblSeason.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // btnCancel
            // 
            this.btnCancel.DialogResult = System.Windows.Forms.DialogResult.Cancel;
            this.btnCancel.Location = new System.Drawing.Point(434, 191);
            this.btnCancel.Name = "btnCancel";
            this.btnCancel.Size = new System.Drawing.Size(75, 44);
            this.btnCancel.TabIndex = 27;
            this.btnCancel.Text = "&Cancel";
            this.btnCancel.UseVisualStyleBackColor = true;
            this.btnCancel.Click += new System.EventHandler(this.btnCancel_Click);
            // 
            // btnSave
            // 
            this.btnSave.DialogResult = System.Windows.Forms.DialogResult.OK;
            this.btnSave.Location = new System.Drawing.Point(317, 191);
            this.btnSave.Name = "btnSave";
            this.btnSave.Size = new System.Drawing.Size(75, 44);
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
            this.statusStrip1.Location = new System.Drawing.Point(0, 262);
            this.statusStrip1.Name = "statusStrip1";
            this.statusStrip1.Size = new System.Drawing.Size(577, 25);
            this.statusStrip1.TabIndex = 25;
            this.statusStrip1.Text = "statusStrip1";
            // 
            // toolStripStatusLabel1
            // 
            this.toolStripStatusLabel1.Name = "toolStripStatusLabel1";
            this.toolStripStatusLabel1.Size = new System.Drawing.Size(49, 20);
            this.toolStripStatusLabel1.Text = "Status";
            // 
            // sslblStatus
            // 
            this.sslblStatus.Name = "sslblStatus";
            this.sslblStatus.Size = new System.Drawing.Size(0, 20);
            // 
            // cmbCompetitionName
            // 
            this.cmbCompetitionName.FormattingEnabled = true;
            this.cmbCompetitionName.Location = new System.Drawing.Point(144, 92);
            this.cmbCompetitionName.Margin = new System.Windows.Forms.Padding(4);
            this.cmbCompetitionName.Name = "cmbCompetitionName";
            this.cmbCompetitionName.Size = new System.Drawing.Size(365, 24);
            this.cmbCompetitionName.TabIndex = 24;
            this.cmbCompetitionName.SelectedValueChanged += new System.EventHandler(this.cmbCompetitionName_SelectedValueChanged);
            // 
            // lblCompetitionName
            // 
            this.lblCompetitionName.AutoSize = true;
            this.lblCompetitionName.Location = new System.Drawing.Point(37, 95);
            this.lblCompetitionName.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.lblCompetitionName.Name = "lblCompetitionName";
            this.lblCompetitionName.Size = new System.Drawing.Size(82, 17);
            this.lblCompetitionName.TabIndex = 23;
            this.lblCompetitionName.Text = "Competition";
            // 
            // CompetitionSelectForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(577, 287);
            this.Controls.Add(this.lblSeason);
            this.Controls.Add(this.btnCancel);
            this.Controls.Add(this.btnSave);
            this.Controls.Add(this.statusStrip1);
            this.Controls.Add(this.cmbCompetitionName);
            this.Controls.Add(this.lblCompetitionName);
            this.Name = "CompetitionSelectForm";
            this.Text = "CompetitionSelectForm";
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
    }
}