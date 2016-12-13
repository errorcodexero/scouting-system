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
			((System.ComponentModel.ISupportInitialize)(this.gridMatchList)).BeginInit();
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
			this.gridMatchList.Location = new System.Drawing.Point(32, 358);
			this.gridMatchList.Margin = new System.Windows.Forms.Padding(8, 7, 8, 7);
			this.gridMatchList.Name = "gridMatchList";
			this.gridMatchList.Size = new System.Drawing.Size(2037, 663);
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
			this.lblMatchList.Location = new System.Drawing.Point(864, 281);
			this.lblMatchList.Margin = new System.Windows.Forms.Padding(8, 0, 8, 0);
			this.lblMatchList.Name = "lblMatchList";
			this.lblMatchList.Size = new System.Drawing.Size(303, 69);
			this.lblMatchList.TabIndex = 11;
			this.lblMatchList.Text = "Match List";
			this.lblMatchList.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
			// 
			// btnAddMatch
			// 
			this.btnAddMatch.Location = new System.Drawing.Point(37, 1090);
			this.btnAddMatch.Margin = new System.Windows.Forms.Padding(8, 7, 8, 7);
			this.btnAddMatch.Name = "btnAddMatch";
			this.btnAddMatch.Size = new System.Drawing.Size(277, 88);
			this.btnAddMatch.TabIndex = 12;
			this.btnAddMatch.Text = "Add Match";
			this.btnAddMatch.UseVisualStyleBackColor = true;
			this.btnAddMatch.Click += new System.EventHandler(this.btnAddMatch_Click);
			// 
			// btnClose
			// 
			this.btnClose.Location = new System.Drawing.Point(1765, 1090);
			this.btnClose.Margin = new System.Windows.Forms.Padding(8, 7, 8, 7);
			this.btnClose.Name = "btnClose";
			this.btnClose.RightToLeft = System.Windows.Forms.RightToLeft.No;
			this.btnClose.Size = new System.Drawing.Size(277, 88);
			this.btnClose.TabIndex = 12;
			this.btnClose.Text = "Close";
			this.btnClose.UseVisualStyleBackColor = true;
			this.btnClose.Click += new System.EventHandler(this.btnClose_Click);
			// 
			// btnRefreshData
			// 
			this.btnRefreshData.Location = new System.Drawing.Point(360, 1090);
			this.btnRefreshData.Margin = new System.Windows.Forms.Padding(8, 7, 8, 7);
			this.btnRefreshData.Name = "btnRefreshData";
			this.btnRefreshData.Size = new System.Drawing.Size(277, 88);
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
			this.lblStatus.Location = new System.Drawing.Point(32, 1261);
			this.lblStatus.Margin = new System.Windows.Forms.Padding(8, 0, 8, 0);
			this.lblStatus.Name = "lblStatus";
			this.lblStatus.Size = new System.Drawing.Size(0, 32);
			this.lblStatus.TabIndex = 13;
			this.lblStatus.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
			// 
			// btnExportData
			// 
			this.btnExportData.Location = new System.Drawing.Point(1445, 1090);
			this.btnExportData.Margin = new System.Windows.Forms.Padding(8, 7, 8, 7);
			this.btnExportData.Name = "btnExportData";
			this.btnExportData.Size = new System.Drawing.Size(277, 88);
			this.btnExportData.TabIndex = 12;
			this.btnExportData.Text = "Export Data";
			this.btnExportData.UseVisualStyleBackColor = true;
			this.btnExportData.Click += new System.EventHandler(this.btnExportData_Click);
			// 
			// btnImportData
			// 
			this.btnImportData.Location = new System.Drawing.Point(1125, 1090);
			this.btnImportData.Margin = new System.Windows.Forms.Padding(8, 7, 8, 7);
			this.btnImportData.Name = "btnImportData";
			this.btnImportData.Size = new System.Drawing.Size(277, 88);
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
			this.lblTestMode.Location = new System.Drawing.Point(1403, 281);
			this.lblTestMode.Margin = new System.Windows.Forms.Padding(8, 0, 8, 0);
			this.lblTestMode.Name = "lblTestMode";
			this.lblTestMode.Size = new System.Drawing.Size(0, 69);
			this.lblTestMode.TabIndex = 17;
			this.lblTestMode.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
			// 
			// lblCompetitionValue
			// 
			this.lblCompetitionValue.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
			this.lblCompetitionValue.AutoSize = true;
			this.lblCompetitionValue.Font = new System.Drawing.Font("Microsoft Sans Serif", 18F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.lblCompetitionValue.Location = new System.Drawing.Point(437, 43);
			this.lblCompetitionValue.Margin = new System.Windows.Forms.Padding(8, 0, 8, 0);
			this.lblCompetitionValue.Name = "lblCompetitionValue";
			this.lblCompetitionValue.Size = new System.Drawing.Size(0, 69);
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
			this.lblSeasonValue.Location = new System.Drawing.Point(437, 148);
			this.lblSeasonValue.Margin = new System.Windows.Forms.Padding(8, 0, 8, 0);
			this.lblSeasonValue.Name = "lblSeasonValue";
			this.lblSeasonValue.Size = new System.Drawing.Size(0, 69);
			this.lblSeasonValue.TabIndex = 20;
			this.lblSeasonValue.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
			this.lblSeasonValue.Visible = false;
			// 
			// btnSetCompetition
			// 
			this.btnSetCompetition.FlatAppearance.MouseOverBackColor = System.Drawing.Color.Silver;
			this.btnSetCompetition.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
			this.btnSetCompetition.Font = new System.Drawing.Font("Microsoft Sans Serif", 14F);
			this.btnSetCompetition.Location = new System.Drawing.Point(45, 33);
			this.btnSetCompetition.Margin = new System.Windows.Forms.Padding(5, 5, 5, 5);
			this.btnSetCompetition.Name = "btnSetCompetition";
			this.btnSetCompetition.Size = new System.Drawing.Size(365, 79);
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
			this.btnSetSeason.Location = new System.Drawing.Point(45, 138);
			this.btnSetSeason.Margin = new System.Windows.Forms.Padding(5, 5, 5, 5);
			this.btnSetSeason.Name = "btnSetSeason";
			this.btnSetSeason.Size = new System.Drawing.Size(365, 79);
			this.btnSetSeason.TabIndex = 22;
			this.btnSetSeason.Text = "Season";
			this.btnSetSeason.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
			this.btnSetSeason.UseVisualStyleBackColor = true;
			this.btnSetSeason.Visible = false;
			this.btnSetSeason.Click += new System.EventHandler(this.btnSetSeason_Click);
			// 
			// btnAddMatchData
			// 
			this.btnAddMatchData.Location = new System.Drawing.Point(688, 1090);
			this.btnAddMatchData.Margin = new System.Windows.Forms.Padding(8, 7, 8, 7);
			this.btnAddMatchData.Name = "btnAddMatchData";
			this.btnAddMatchData.Size = new System.Drawing.Size(277, 88);
			this.btnAddMatchData.TabIndex = 23;
			this.btnAddMatchData.Text = "Add Match Data";
			this.btnAddMatchData.UseVisualStyleBackColor = true;
			this.btnAddMatchData.Click += new System.EventHandler(this.btnAddMatchData_Click);
			// 
			// MatchListForm
			// 
			this.AutoScaleDimensions = new System.Drawing.SizeF(16F, 31F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.ClientSize = new System.Drawing.Size(2160, 1302);
			this.Controls.Add(this.btnAddMatchData);
			this.Controls.Add(this.btnSetSeason);
			this.Controls.Add(this.btnSetCompetition);
			this.Controls.Add(this.lblSeasonValue);
			this.Controls.Add(this.lblCompetitionValue);
			this.Controls.Add(this.lblTestMode);
			this.Controls.Add(this.lblStatus);
			this.Controls.Add(this.btnClose);
			this.Controls.Add(this.btnImportData);
			this.Controls.Add(this.btnExportData);
			this.Controls.Add(this.btnRefreshData);
			this.Controls.Add(this.btnAddMatch);
			this.Controls.Add(this.lblMatchList);
			this.Controls.Add(this.gridMatchList);
			this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
			this.Margin = new System.Windows.Forms.Padding(8, 7, 8, 7);
			this.Name = "MatchListForm";
			this.Text = "Match List";
			((System.ComponentModel.ISupportInitialize)(this.gridMatchList)).EndInit();
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
    }
}

