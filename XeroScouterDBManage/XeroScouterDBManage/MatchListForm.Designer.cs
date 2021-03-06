﻿namespace XeroScouterDBManage_Server
{
    partial class MatchListForm
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
			System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(MatchListForm));
			this.gridMatchList = new System.Windows.Forms.DataGridView();
			this.lblMatchList = new System.Windows.Forms.Label();
			this.btnAddMatch = new System.Windows.Forms.Button();
			this.btnClose = new System.Windows.Forms.Button();
			this.btnRefreshData = new System.Windows.Forms.Button();
			this.lblStatus = new System.Windows.Forms.Label();
			this.btnExportData = new System.Windows.Forms.Button();
			this.btnImportData = new System.Windows.Forms.Button();
			this.lblTestMode = new System.Windows.Forms.Label();
			this.lblCompetitionValue = new System.Windows.Forms.Label();
			this.lblSeasonValue = new System.Windows.Forms.Label();
			this.btnSetCompetition = new System.Windows.Forms.Button();
			this.btnSetSeason = new System.Windows.Forms.Button();
			this.btnAddMatchData = new System.Windows.Forms.Button();
			this.menuStrip1 = new System.Windows.Forms.MenuStrip();
			this.fileToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
			this.modeToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
			this.testModeToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
			this.panel1 = new System.Windows.Forms.Panel();
			this.panel2 = new System.Windows.Forms.Panel();
			this.panel3 = new System.Windows.Forms.Panel();
			this.panel4 = new System.Windows.Forms.Panel();
			this.panel5 = new System.Windows.Forms.Panel();
			this.statusStrip1 = new System.Windows.Forms.StatusStrip();
			((System.ComponentModel.ISupportInitialize)(this.gridMatchList)).BeginInit();
			this.menuStrip1.SuspendLayout();
			this.panel1.SuspendLayout();
			this.panel2.SuspendLayout();
			this.panel3.SuspendLayout();
			this.panel4.SuspendLayout();
			this.panel5.SuspendLayout();
			this.SuspendLayout();
			// 
			// gridMatchList
			// 
			this.gridMatchList.AllowUserToAddRows = false;
			this.gridMatchList.AllowUserToDeleteRows = false;
			this.gridMatchList.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
			this.gridMatchList.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.AllCells;
			this.gridMatchList.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
			this.gridMatchList.Location = new System.Drawing.Point(38, 83);
			this.gridMatchList.Margin = new System.Windows.Forms.Padding(7);
			this.gridMatchList.Name = "gridMatchList";
			this.gridMatchList.Size = new System.Drawing.Size(1783, 620);
			this.gridMatchList.TabIndex = 10;
			this.gridMatchList.CellClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.gridMatchList_CellClick);
			this.gridMatchList.CellDoubleClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.gridMatchList_CellDoubleClick);
			this.gridMatchList.DataBindingComplete += new System.Windows.Forms.DataGridViewBindingCompleteEventHandler(this.gridMatchList_DataBindingComplete);
			this.gridMatchList.RowHeaderMouseDoubleClick += new System.Windows.Forms.DataGridViewCellMouseEventHandler(this.gridMatchList_RowHeaderMouseDoubleClick);
			// 
			// lblMatchList
			// 
			this.lblMatchList.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
			this.lblMatchList.AutoSize = true;
			this.lblMatchList.Font = new System.Drawing.Font("Microsoft Sans Serif", 18F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.lblMatchList.Location = new System.Drawing.Point(766, 11);
			this.lblMatchList.Margin = new System.Windows.Forms.Padding(7, 0, 7, 0);
			this.lblMatchList.Name = "lblMatchList";
			this.lblMatchList.Size = new System.Drawing.Size(273, 63);
			this.lblMatchList.TabIndex = 11;
			this.lblMatchList.Text = "Match List";
			this.lblMatchList.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
			// 
			// btnAddMatch
			// 
			this.btnAddMatch.Location = new System.Drawing.Point(23, 18);
			this.btnAddMatch.Margin = new System.Windows.Forms.Padding(7);
			this.btnAddMatch.Name = "btnAddMatch";
			this.btnAddMatch.Size = new System.Drawing.Size(243, 83);
			this.btnAddMatch.TabIndex = 12;
			this.btnAddMatch.Text = "Add Match";
			this.btnAddMatch.UseVisualStyleBackColor = true;
			this.btnAddMatch.Click += new System.EventHandler(this.btnAddMatch_Click);
			// 
			// btnClose
			// 
			this.btnClose.Location = new System.Drawing.Point(25, 18);
			this.btnClose.Margin = new System.Windows.Forms.Padding(7);
			this.btnClose.Name = "btnClose";
			this.btnClose.RightToLeft = System.Windows.Forms.RightToLeft.No;
			this.btnClose.Size = new System.Drawing.Size(243, 83);
			this.btnClose.TabIndex = 12;
			this.btnClose.Text = "Close";
			this.btnClose.UseVisualStyleBackColor = true;
			this.btnClose.Click += new System.EventHandler(this.btnClose_Click);
			// 
			// btnRefreshData
			// 
			this.btnRefreshData.Location = new System.Drawing.Point(299, 18);
			this.btnRefreshData.Margin = new System.Windows.Forms.Padding(7);
			this.btnRefreshData.Name = "btnRefreshData";
			this.btnRefreshData.Size = new System.Drawing.Size(243, 83);
			this.btnRefreshData.TabIndex = 12;
			this.btnRefreshData.Text = "Refresh Data";
			this.btnRefreshData.UseVisualStyleBackColor = true;
			this.btnRefreshData.Click += new System.EventHandler(this.btnRefreshData_Click);
			// 
			// lblStatus
			// 
			this.lblStatus.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
			this.lblStatus.AutoSize = true;
			this.lblStatus.Enabled = false;
			this.lblStatus.Location = new System.Drawing.Point(28, 1358);
			this.lblStatus.Margin = new System.Windows.Forms.Padding(7, 0, 7, 0);
			this.lblStatus.Name = "lblStatus";
			this.lblStatus.Size = new System.Drawing.Size(0, 29);
			this.lblStatus.TabIndex = 13;
			this.lblStatus.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
			// 
			// btnExportData
			// 
			this.btnExportData.Location = new System.Drawing.Point(274, 18);
			this.btnExportData.Margin = new System.Windows.Forms.Padding(7);
			this.btnExportData.Name = "btnExportData";
			this.btnExportData.Size = new System.Drawing.Size(243, 83);
			this.btnExportData.TabIndex = 12;
			this.btnExportData.Text = "Export Data";
			this.btnExportData.UseVisualStyleBackColor = true;
			this.btnExportData.Click += new System.EventHandler(this.btnExportData_Click);
			// 
			// btnImportData
			// 
			this.btnImportData.Location = new System.Drawing.Point(17, 18);
			this.btnImportData.Margin = new System.Windows.Forms.Padding(7);
			this.btnImportData.Name = "btnImportData";
			this.btnImportData.Size = new System.Drawing.Size(243, 83);
			this.btnImportData.TabIndex = 12;
			this.btnImportData.Text = "Import Data";
			this.btnImportData.UseVisualStyleBackColor = true;
			this.btnImportData.Click += new System.EventHandler(this.btnImportData_Click);
			// 
			// lblTestMode
			// 
			this.lblTestMode.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
			this.lblTestMode.AutoSize = true;
			this.lblTestMode.Font = new System.Drawing.Font("Microsoft Sans Serif", 18F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.lblTestMode.Location = new System.Drawing.Point(1101, 11);
			this.lblTestMode.Margin = new System.Windows.Forms.Padding(7, 0, 7, 0);
			this.lblTestMode.Name = "lblTestMode";
			this.lblTestMode.Size = new System.Drawing.Size(0, 63);
			this.lblTestMode.TabIndex = 17;
			this.lblTestMode.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
			// 
			// lblCompetitionValue
			// 
			this.lblCompetitionValue.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
			this.lblCompetitionValue.AutoSize = true;
			this.lblCompetitionValue.Font = new System.Drawing.Font("Microsoft Sans Serif", 18F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.lblCompetitionValue.Location = new System.Drawing.Point(383, 93);
			this.lblCompetitionValue.Margin = new System.Windows.Forms.Padding(7, 0, 7, 0);
			this.lblCompetitionValue.Name = "lblCompetitionValue";
			this.lblCompetitionValue.Size = new System.Drawing.Size(0, 63);
			this.lblCompetitionValue.TabIndex = 18;
			this.lblCompetitionValue.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
			// 
			// lblSeasonValue
			// 
			this.lblSeasonValue.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
			this.lblSeasonValue.AutoSize = true;
			this.lblSeasonValue.Enabled = false;
			this.lblSeasonValue.Font = new System.Drawing.Font("Microsoft Sans Serif", 18F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.lblSeasonValue.Location = new System.Drawing.Point(383, 191);
			this.lblSeasonValue.Margin = new System.Windows.Forms.Padding(7, 0, 7, 0);
			this.lblSeasonValue.Name = "lblSeasonValue";
			this.lblSeasonValue.Size = new System.Drawing.Size(0, 63);
			this.lblSeasonValue.TabIndex = 20;
			this.lblSeasonValue.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
			this.lblSeasonValue.Visible = false;
			// 
			// btnSetCompetition
			// 
			this.btnSetCompetition.FlatAppearance.MouseOverBackColor = System.Drawing.Color.Silver;
			this.btnSetCompetition.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
			this.btnSetCompetition.Font = new System.Drawing.Font("Microsoft Sans Serif", 14F);
			this.btnSetCompetition.Location = new System.Drawing.Point(40, 84);
			this.btnSetCompetition.Margin = new System.Windows.Forms.Padding(5, 4, 5, 4);
			this.btnSetCompetition.Name = "btnSetCompetition";
			this.btnSetCompetition.Size = new System.Drawing.Size(320, 74);
			this.btnSetCompetition.TabIndex = 21;
			this.btnSetCompetition.Text = "Competition";
			this.btnSetCompetition.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
			this.btnSetCompetition.UseVisualStyleBackColor = true;
			this.btnSetCompetition.Click += new System.EventHandler(this.btnSetCompetition_Click);
			// 
			// btnSetSeason
			// 
			this.btnSetSeason.Enabled = false;
			this.btnSetSeason.FlatAppearance.MouseOverBackColor = System.Drawing.Color.Silver;
			this.btnSetSeason.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
			this.btnSetSeason.Font = new System.Drawing.Font("Microsoft Sans Serif", 14F);
			this.btnSetSeason.Location = new System.Drawing.Point(40, 182);
			this.btnSetSeason.Margin = new System.Windows.Forms.Padding(5, 4, 5, 4);
			this.btnSetSeason.Name = "btnSetSeason";
			this.btnSetSeason.Size = new System.Drawing.Size(320, 74);
			this.btnSetSeason.TabIndex = 22;
			this.btnSetSeason.Text = "Season";
			this.btnSetSeason.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
			this.btnSetSeason.UseVisualStyleBackColor = true;
			this.btnSetSeason.Visible = false;
			this.btnSetSeason.Click += new System.EventHandler(this.btnSetSeason_Click);
			// 
			// btnAddMatchData
			// 
			this.btnAddMatchData.Location = new System.Drawing.Point(569, 18);
			this.btnAddMatchData.Margin = new System.Windows.Forms.Padding(7);
			this.btnAddMatchData.Name = "btnAddMatchData";
			this.btnAddMatchData.Size = new System.Drawing.Size(243, 83);
			this.btnAddMatchData.TabIndex = 23;
			this.btnAddMatchData.Text = "Add Match Data";
			this.btnAddMatchData.UseVisualStyleBackColor = true;
			this.btnAddMatchData.Click += new System.EventHandler(this.btnAddMatchData_Click);
			// 
			// menuStrip1
			// 
			this.menuStrip1.ImageScalingSize = new System.Drawing.Size(36, 36);
			this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.fileToolStripMenuItem,
            this.modeToolStripMenuItem});
			this.menuStrip1.Location = new System.Drawing.Point(0, 0);
			this.menuStrip1.Name = "menuStrip1";
			this.menuStrip1.Size = new System.Drawing.Size(1890, 45);
			this.menuStrip1.TabIndex = 24;
			this.menuStrip1.Text = "menuStrip1";
			// 
			// fileToolStripMenuItem
			// 
			this.fileToolStripMenuItem.Name = "fileToolStripMenuItem";
			this.fileToolStripMenuItem.Size = new System.Drawing.Size(70, 41);
			this.fileToolStripMenuItem.Text = "File";
			// 
			// modeToolStripMenuItem
			// 
			this.modeToolStripMenuItem.CheckOnClick = true;
			this.modeToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.testModeToolStripMenuItem});
			this.modeToolStripMenuItem.Name = "modeToolStripMenuItem";
			this.modeToolStripMenuItem.Size = new System.Drawing.Size(99, 41);
			this.modeToolStripMenuItem.Text = "Mode";
			this.modeToolStripMenuItem.ToolTipText = "Set test mode to use test database";
			// 
			// testModeToolStripMenuItem
			// 
			this.testModeToolStripMenuItem.CheckOnClick = true;
			this.testModeToolStripMenuItem.Name = "testModeToolStripMenuItem";
			this.testModeToolStripMenuItem.Size = new System.Drawing.Size(247, 42);
			this.testModeToolStripMenuItem.Text = "Test Mode";
			this.testModeToolStripMenuItem.CheckedChanged += new System.EventHandler(this.testModeToolStripMenuItem_CheckedChanged);
			// 
			// panel1
			// 
			this.panel1.Controls.Add(this.btnAddMatch);
			this.panel1.Controls.Add(this.btnAddMatchData);
			this.panel1.Controls.Add(this.btnRefreshData);
			this.panel1.Location = new System.Drawing.Point(28, 983);
			this.panel1.Name = "panel1";
			this.panel1.Size = new System.Drawing.Size(839, 119);
			this.panel1.TabIndex = 25;
			// 
			// panel2
			// 
			this.panel2.Controls.Add(this.btnImportData);
			this.panel2.Controls.Add(this.btnExportData);
			this.panel2.Location = new System.Drawing.Point(967, 983);
			this.panel2.Name = "panel2";
			this.panel2.Size = new System.Drawing.Size(533, 119);
			this.panel2.TabIndex = 26;
			// 
			// panel3
			// 
			this.panel3.Controls.Add(this.btnClose);
			this.panel3.Location = new System.Drawing.Point(1568, 983);
			this.panel3.Name = "panel3";
			this.panel3.Size = new System.Drawing.Size(287, 119);
			this.panel3.TabIndex = 27;
			// 
			// panel4
			// 
			this.panel4.Controls.Add(this.gridMatchList);
			this.panel4.Controls.Add(this.lblMatchList);
			this.panel4.Controls.Add(this.lblTestMode);
			this.panel4.Location = new System.Drawing.Point(12, 263);
			this.panel4.Name = "panel4";
			this.panel4.Size = new System.Drawing.Size(1865, 714);
			this.panel4.TabIndex = 28;
			// 
			// panel5
			// 
			this.panel5.Controls.Add(this.statusStrip1);
			this.panel5.Location = new System.Drawing.Point(13, 1108);
			this.panel5.Name = "panel5";
			this.panel5.Size = new System.Drawing.Size(1865, 66);
			this.panel5.TabIndex = 29;
			// 
			// statusStrip1
			// 
			this.statusStrip1.ImageScalingSize = new System.Drawing.Size(36, 36);
			this.statusStrip1.Location = new System.Drawing.Point(0, 44);
			this.statusStrip1.Name = "statusStrip1";
			this.statusStrip1.Size = new System.Drawing.Size(1865, 22);
			this.statusStrip1.TabIndex = 0;
			// 
			// MatchListForm
			// 
			this.AutoScaleDimensions = new System.Drawing.SizeF(216F, 216F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Dpi;
			this.AutoSize = true;
			this.ClientSize = new System.Drawing.Size(1890, 1164);
			this.Controls.Add(this.panel5);
			this.Controls.Add(this.panel4);
			this.Controls.Add(this.panel3);
			this.Controls.Add(this.panel2);
			this.Controls.Add(this.panel1);
			this.Controls.Add(this.btnSetSeason);
			this.Controls.Add(this.btnSetCompetition);
			this.Controls.Add(this.lblSeasonValue);
			this.Controls.Add(this.lblCompetitionValue);
			this.Controls.Add(this.lblStatus);
			this.Controls.Add(this.menuStrip1);
			this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
			this.MainMenuStrip = this.menuStrip1;
			this.Margin = new System.Windows.Forms.Padding(7);
			this.Name = "MatchListForm";
			this.Text = "Match List";
			((System.ComponentModel.ISupportInitialize)(this.gridMatchList)).EndInit();
			this.menuStrip1.ResumeLayout(false);
			this.menuStrip1.PerformLayout();
			this.panel1.ResumeLayout(false);
			this.panel2.ResumeLayout(false);
			this.panel3.ResumeLayout(false);
			this.panel4.ResumeLayout(false);
			this.panel4.PerformLayout();
			this.panel5.ResumeLayout(false);
			this.panel5.PerformLayout();
			this.ResumeLayout(false);
			this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.DataGridView gridMatchList;
        private System.Windows.Forms.Label lblMatchList;
        private System.Windows.Forms.Button btnAddMatch;
        private System.Windows.Forms.Button btnClose;
        private System.Windows.Forms.Button btnRefreshData;
        private System.Windows.Forms.Label lblStatus;
        private System.Windows.Forms.Button btnExportData;
        private System.Windows.Forms.Button btnImportData;
        private System.Windows.Forms.Label lblTestMode;
        private System.Windows.Forms.Label lblCompetitionValue;
        private System.Windows.Forms.Label lblSeasonValue;
        private System.Windows.Forms.Button btnSetCompetition;
        private System.Windows.Forms.Button btnSetSeason;
        private System.Windows.Forms.Button btnAddMatchData;
		private System.Windows.Forms.MenuStrip menuStrip1;
		private System.Windows.Forms.ToolStripMenuItem fileToolStripMenuItem;
		private System.Windows.Forms.ToolStripMenuItem modeToolStripMenuItem;
		private System.Windows.Forms.ToolStripMenuItem testModeToolStripMenuItem;
		private System.Windows.Forms.Panel panel1;
		private System.Windows.Forms.Panel panel2;
		private System.Windows.Forms.Panel panel3;
		private System.Windows.Forms.Panel panel4;
		private System.Windows.Forms.Panel panel5;
		private System.Windows.Forms.StatusStrip statusStrip1;
	}
}

