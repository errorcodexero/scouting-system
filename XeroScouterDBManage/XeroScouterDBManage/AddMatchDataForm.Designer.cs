namespace XeroScouterDBManage_Server
{
    partial class AddMatchDataForm
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
            this.txtMatchType = new System.Windows.Forms.TextBox();
            this.lblMatchType = new System.Windows.Forms.Label();
            this.txtMatchNumber = new System.Windows.Forms.TextBox();
            this.lblMatchNumber = new System.Windows.Forms.Label();
            this.lblAddAMatch = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // txtMatchType
            // 
            this.txtMatchType.Enabled = false;
            this.txtMatchType.Location = new System.Drawing.Point(361, 46);
            this.txtMatchType.Name = "txtMatchType";
            this.txtMatchType.Size = new System.Drawing.Size(100, 20);
            this.txtMatchType.TabIndex = 7;
            this.txtMatchType.Text = "Qualification";
            // 
            // lblMatchType
            // 
            this.lblMatchType.AutoSize = true;
            this.lblMatchType.Location = new System.Drawing.Point(268, 50);
            this.lblMatchType.Name = "lblMatchType";
            this.lblMatchType.Size = new System.Drawing.Size(64, 13);
            this.lblMatchType.TabIndex = 8;
            this.lblMatchType.Text = "Match Type";
            // 
            // txtMatchNumber
            // 
            this.txtMatchNumber.Enabled = false;
            this.txtMatchNumber.Location = new System.Drawing.Point(122, 46);
            this.txtMatchNumber.Name = "txtMatchNumber";
            this.txtMatchNumber.Size = new System.Drawing.Size(100, 20);
            this.txtMatchNumber.TabIndex = 5;
            // 
            // lblMatchNumber
            // 
            this.lblMatchNumber.AutoSize = true;
            this.lblMatchNumber.Location = new System.Drawing.Point(29, 50);
            this.lblMatchNumber.Name = "lblMatchNumber";
            this.lblMatchNumber.Size = new System.Drawing.Size(77, 13);
            this.lblMatchNumber.TabIndex = 6;
            this.lblMatchNumber.Text = "Match Number";
            // 
            // lblAddAMatch
            // 
            this.lblAddAMatch.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.lblAddAMatch.AutoSize = true;
            this.lblAddAMatch.Font = new System.Drawing.Font("Microsoft Sans Serif", 18F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblAddAMatch.Location = new System.Drawing.Point(159, 9);
            this.lblAddAMatch.Name = "lblAddAMatch";
            this.lblAddAMatch.Size = new System.Drawing.Size(181, 29);
            this.lblAddAMatch.TabIndex = 23;
            this.lblAddAMatch.Text = "Add Match Data";
            this.lblAddAMatch.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // AddMatchDataForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(527, 491);
            this.Controls.Add(this.lblAddAMatch);
            this.Controls.Add(this.txtMatchType);
            this.Controls.Add(this.lblMatchType);
            this.Controls.Add(this.txtMatchNumber);
            this.Controls.Add(this.lblMatchNumber);
            this.Name = "AddMatchDataForm";
            this.Text = "AddMatchDataForm";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox txtMatchType;
        private System.Windows.Forms.Label lblMatchType;
        private System.Windows.Forms.TextBox txtMatchNumber;
        private System.Windows.Forms.Label lblMatchNumber;
        private System.Windows.Forms.Label lblAddAMatch;
    }
}