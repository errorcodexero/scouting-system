namespace XeroScouterDBManage_Server
{
	partial class TeamMatchActionEntryForm
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
			this.components = new System.ComponentModel.Container();
			this.lblScouter = new System.Windows.Forms.Label();
			this.txtScouter = new System.Windows.Forms.TextBox();
			this.lblAddAMatch = new System.Windows.Forms.Label();
			this.errorProvider1 = new System.Windows.Forms.ErrorProvider(this.components);
			this.panel1 = new System.Windows.Forms.Panel();
			this.cmbAllianceColor = new System.Windows.Forms.ComboBox();
			this.lblAllianceColor = new System.Windows.Forms.Label();
			this.txtTeamNumber = new System.Windows.Forms.TextBox();
			this.lblTeamNumnber = new System.Windows.Forms.Label();
			this.txtMatchNumber = new System.Windows.Forms.TextBox();
			this.lblMatchNumber = new System.Windows.Forms.Label();
			this.panel2 = new System.Windows.Forms.Panel();
			this.lblBlueAlliance = new System.Windows.Forms.Label();
			this.txtAutoBunniesScored = new System.Windows.Forms.TextBox();
			this.lblAutoBunniesScored = new System.Windows.Forms.Label();
			this.txtAutoBunniesPicked = new System.Windows.Forms.TextBox();
			this.lblAutoBunniesPicked = new System.Windows.Forms.Label();
			this.txtAutoLinesCrossed = new System.Windows.Forms.TextBox();
			this.lblAutoLinesCrossed = new System.Windows.Forms.Label();
			this.panel3 = new System.Windows.Forms.Panel();
			this.txtTeleBunniesScored = new System.Windows.Forms.TextBox();
			this.lblTeleBunniesScored = new System.Windows.Forms.Label();
			this.label11 = new System.Windows.Forms.Label();
			this.txtTeleBunniesStolen = new System.Windows.Forms.TextBox();
			this.lblTeleBunniesStolen = new System.Windows.Forms.Label();
			this.txtTeleBunniesGround = new System.Windows.Forms.TextBox();
			this.lblTeleBunniesGround = new System.Windows.Forms.Label();
			this.txtTeleLinesCrossed = new System.Windows.Forms.TextBox();
			this.lblTeleLinesCrossed = new System.Windows.Forms.Label();
			this.panel4 = new System.Windows.Forms.Panel();
			this.label15 = new System.Windows.Forms.Label();
			this.txtNerfShotsMissed = new System.Windows.Forms.TextBox();
			this.lblNerfShotsMissed = new System.Windows.Forms.Label();
			this.txtNerfShotsHit = new System.Windows.Forms.TextBox();
			this.lblNerfShotsHit = new System.Windows.Forms.Label();
			this.panel5 = new System.Windows.Forms.Panel();
			this.chkBreakdownFlag = new System.Windows.Forms.CheckBox();
			this.chkDefenceFlag = new System.Windows.Forms.CheckBox();
			this.panel6 = new System.Windows.Forms.Panel();
			this.btnCancel = new System.Windows.Forms.Button();
			this.btnSave = new System.Windows.Forms.Button();
			this.panel7 = new System.Windows.Forms.Panel();
			this.statusStrip1 = new System.Windows.Forms.StatusStrip();
			this.toolStripStatusLabel1 = new System.Windows.Forms.ToolStripStatusLabel();
			((System.ComponentModel.ISupportInitialize)(this.errorProvider1)).BeginInit();
			this.panel1.SuspendLayout();
			this.panel2.SuspendLayout();
			this.panel3.SuspendLayout();
			this.panel4.SuspendLayout();
			this.panel5.SuspendLayout();
			this.panel6.SuspendLayout();
			this.panel7.SuspendLayout();
			this.statusStrip1.SuspendLayout();
			this.SuspendLayout();
			// 
			// lblScouter
			// 
			this.lblScouter.AutoSize = true;
			this.lblScouter.Location = new System.Drawing.Point(299, 181);
			this.lblScouter.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
			this.lblScouter.Name = "lblScouter";
			this.lblScouter.Size = new System.Drawing.Size(102, 29);
			this.lblScouter.TabIndex = 0;
			this.lblScouter.Text = "Scouter:";
			// 
			// txtScouter
			// 
			this.txtScouter.Location = new System.Drawing.Point(415, 178);
			this.txtScouter.Margin = new System.Windows.Forms.Padding(2);
			this.txtScouter.Name = "txtScouter";
			this.txtScouter.Size = new System.Drawing.Size(496, 35);
			this.txtScouter.TabIndex = 1;
			this.txtScouter.Validating += new System.ComponentModel.CancelEventHandler(this.textbox_Validating);
			this.txtScouter.Validated += new System.EventHandler(this.textbox_Validated);
			// 
			// lblAddAMatch
			// 
			this.lblAddAMatch.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
			this.lblAddAMatch.AutoSize = true;
			this.lblAddAMatch.Font = new System.Drawing.Font("Microsoft Sans Serif", 18F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.lblAddAMatch.Location = new System.Drawing.Point(408, 49);
			this.lblAddAMatch.Margin = new System.Windows.Forms.Padding(7, 0, 7, 0);
			this.lblAddAMatch.Name = "lblAddAMatch";
			this.lblAddAMatch.Size = new System.Drawing.Size(412, 63);
			this.lblAddAMatch.TabIndex = 24;
			this.lblAddAMatch.Text = "Add Match Data";
			this.lblAddAMatch.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
			// 
			// errorProvider1
			// 
			this.errorProvider1.ContainerControl = this;
			// 
			// panel1
			// 
			this.panel1.Controls.Add(this.cmbAllianceColor);
			this.panel1.Controls.Add(this.lblAllianceColor);
			this.panel1.Controls.Add(this.txtTeamNumber);
			this.panel1.Controls.Add(this.lblTeamNumnber);
			this.panel1.Controls.Add(this.txtMatchNumber);
			this.panel1.Controls.Add(this.lblMatchNumber);
			this.panel1.Location = new System.Drawing.Point(14, 249);
			this.panel1.Name = "panel1";
			this.panel1.Size = new System.Drawing.Size(1215, 112);
			this.panel1.TabIndex = 48;
			// 
			// cmbAllianceColor
			// 
			this.cmbAllianceColor.FormattingEnabled = true;
			this.cmbAllianceColor.Items.AddRange(new object[] {
            "Blue",
            "Red"});
			this.cmbAllianceColor.Location = new System.Drawing.Point(975, 38);
			this.cmbAllianceColor.Margin = new System.Windows.Forms.Padding(2);
			this.cmbAllianceColor.Name = "cmbAllianceColor";
			this.cmbAllianceColor.Size = new System.Drawing.Size(184, 37);
			this.cmbAllianceColor.TabIndex = 10;
			// 
			// lblAllianceColor
			// 
			this.lblAllianceColor.AutoSize = true;
			this.lblAllianceColor.Location = new System.Drawing.Point(786, 40);
			this.lblAllianceColor.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
			this.lblAllianceColor.Name = "lblAllianceColor";
			this.lblAllianceColor.Size = new System.Drawing.Size(169, 29);
			this.lblAllianceColor.TabIndex = 12;
			this.lblAllianceColor.Text = "Alliance Color:";
			// 
			// txtTeamNumber
			// 
			this.txtTeamNumber.Location = new System.Drawing.Point(534, 38);
			this.txtTeamNumber.Margin = new System.Windows.Forms.Padding(2);
			this.txtTeamNumber.Name = "txtTeamNumber";
			this.txtTeamNumber.Size = new System.Drawing.Size(209, 35);
			this.txtTeamNumber.TabIndex = 9;
			this.txtTeamNumber.Validating += new System.ComponentModel.CancelEventHandler(this.textbox_Validating);
			this.txtTeamNumber.Validated += new System.EventHandler(this.textbox_Validated);
			// 
			// lblTeamNumnber
			// 
			this.lblTeamNumnber.AutoSize = true;
			this.lblTeamNumnber.Location = new System.Drawing.Point(422, 40);
			this.lblTeamNumnber.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
			this.lblTeamNumnber.Name = "lblTeamNumnber";
			this.lblTeamNumnber.Size = new System.Drawing.Size(95, 29);
			this.lblTeamNumnber.TabIndex = 11;
			this.lblTeamNumnber.Text = "Team#:";
			// 
			// txtMatchNumber
			// 
			this.txtMatchNumber.Location = new System.Drawing.Point(168, 38);
			this.txtMatchNumber.Margin = new System.Windows.Forms.Padding(2);
			this.txtMatchNumber.Name = "txtMatchNumber";
			this.txtMatchNumber.Size = new System.Drawing.Size(209, 35);
			this.txtMatchNumber.TabIndex = 7;
			this.txtMatchNumber.Validating += new System.ComponentModel.CancelEventHandler(this.textbox_Validating);
			this.txtMatchNumber.Validated += new System.EventHandler(this.textbox_Validated);
			// 
			// lblMatchNumber
			// 
			this.lblMatchNumber.AutoSize = true;
			this.lblMatchNumber.Location = new System.Drawing.Point(56, 40);
			this.lblMatchNumber.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
			this.lblMatchNumber.Name = "lblMatchNumber";
			this.lblMatchNumber.Size = new System.Drawing.Size(96, 29);
			this.lblMatchNumber.TabIndex = 8;
			this.lblMatchNumber.Text = "Match#:";
			// 
			// panel2
			// 
			this.panel2.Controls.Add(this.lblBlueAlliance);
			this.panel2.Controls.Add(this.txtAutoBunniesScored);
			this.panel2.Controls.Add(this.lblAutoBunniesScored);
			this.panel2.Controls.Add(this.txtAutoBunniesPicked);
			this.panel2.Controls.Add(this.lblAutoBunniesPicked);
			this.panel2.Controls.Add(this.txtAutoLinesCrossed);
			this.panel2.Controls.Add(this.lblAutoLinesCrossed);
			this.panel2.Location = new System.Drawing.Point(14, 367);
			this.panel2.Name = "panel2";
			this.panel2.Size = new System.Drawing.Size(1215, 141);
			this.panel2.TabIndex = 49;
			// 
			// lblBlueAlliance
			// 
			this.lblBlueAlliance.AutoSize = true;
			this.lblBlueAlliance.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Underline))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.lblBlueAlliance.Location = new System.Drawing.Point(550, 14);
			this.lblBlueAlliance.Margin = new System.Windows.Forms.Padding(7, 0, 7, 0);
			this.lblBlueAlliance.Name = "lblBlueAlliance";
			this.lblBlueAlliance.Size = new System.Drawing.Size(95, 40);
			this.lblBlueAlliance.TabIndex = 45;
			this.lblBlueAlliance.Text = "Auto";
			// 
			// txtAutoBunniesScored
			// 
			this.txtAutoBunniesScored.Location = new System.Drawing.Point(975, 79);
			this.txtAutoBunniesScored.Margin = new System.Windows.Forms.Padding(2);
			this.txtAutoBunniesScored.Name = "txtAutoBunniesScored";
			this.txtAutoBunniesScored.Size = new System.Drawing.Size(184, 35);
			this.txtAutoBunniesScored.TabIndex = 41;
			this.txtAutoBunniesScored.Validating += new System.ComponentModel.CancelEventHandler(this.textbox_Validating);
			this.txtAutoBunniesScored.Validated += new System.EventHandler(this.textbox_Validated);
			// 
			// lblAutoBunniesScored
			// 
			this.lblAutoBunniesScored.AutoSize = true;
			this.lblAutoBunniesScored.Location = new System.Drawing.Point(786, 81);
			this.lblAutoBunniesScored.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
			this.lblAutoBunniesScored.Name = "lblAutoBunniesScored";
			this.lblAutoBunniesScored.Size = new System.Drawing.Size(190, 29);
			this.lblAutoBunniesScored.TabIndex = 44;
			this.lblAutoBunniesScored.Text = "Bunnies Scored:";
			// 
			// txtAutoBunniesPicked
			// 
			this.txtAutoBunniesPicked.Location = new System.Drawing.Point(611, 79);
			this.txtAutoBunniesPicked.Margin = new System.Windows.Forms.Padding(2);
			this.txtAutoBunniesPicked.Name = "txtAutoBunniesPicked";
			this.txtAutoBunniesPicked.Size = new System.Drawing.Size(132, 35);
			this.txtAutoBunniesPicked.TabIndex = 40;
			this.txtAutoBunniesPicked.Validating += new System.ComponentModel.CancelEventHandler(this.textbox_Validating);
			this.txtAutoBunniesPicked.Validated += new System.EventHandler(this.textbox_Validated);
			// 
			// lblAutoBunniesPicked
			// 
			this.lblAutoBunniesPicked.AutoSize = true;
			this.lblAutoBunniesPicked.Location = new System.Drawing.Point(422, 81);
			this.lblAutoBunniesPicked.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
			this.lblAutoBunniesPicked.Name = "lblAutoBunniesPicked";
			this.lblAutoBunniesPicked.Size = new System.Drawing.Size(186, 29);
			this.lblAutoBunniesPicked.TabIndex = 43;
			this.lblAutoBunniesPicked.Text = "Bunnies Picked:";
			// 
			// txtAutoLinesCrossed
			// 
			this.txtAutoLinesCrossed.Location = new System.Drawing.Point(231, 79);
			this.txtAutoLinesCrossed.Margin = new System.Windows.Forms.Padding(2);
			this.txtAutoLinesCrossed.Name = "txtAutoLinesCrossed";
			this.txtAutoLinesCrossed.Size = new System.Drawing.Size(146, 35);
			this.txtAutoLinesCrossed.TabIndex = 39;
			this.txtAutoLinesCrossed.Validating += new System.ComponentModel.CancelEventHandler(this.textbox_Validating);
			this.txtAutoLinesCrossed.Validated += new System.EventHandler(this.textbox_Validated);
			// 
			// lblAutoLinesCrossed
			// 
			this.lblAutoLinesCrossed.AutoSize = true;
			this.lblAutoLinesCrossed.Location = new System.Drawing.Point(56, 81);
			this.lblAutoLinesCrossed.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
			this.lblAutoLinesCrossed.Name = "lblAutoLinesCrossed";
			this.lblAutoLinesCrossed.Size = new System.Drawing.Size(174, 29);
			this.lblAutoLinesCrossed.TabIndex = 42;
			this.lblAutoLinesCrossed.Text = "Lines Crossed:";
			// 
			// panel3
			// 
			this.panel3.Controls.Add(this.txtTeleBunniesScored);
			this.panel3.Controls.Add(this.lblTeleBunniesScored);
			this.panel3.Controls.Add(this.label11);
			this.panel3.Controls.Add(this.txtTeleBunniesStolen);
			this.panel3.Controls.Add(this.lblTeleBunniesStolen);
			this.panel3.Controls.Add(this.txtTeleBunniesGround);
			this.panel3.Controls.Add(this.lblTeleBunniesGround);
			this.panel3.Controls.Add(this.txtTeleLinesCrossed);
			this.panel3.Controls.Add(this.lblTeleLinesCrossed);
			this.panel3.Location = new System.Drawing.Point(14, 515);
			this.panel3.Name = "panel3";
			this.panel3.Size = new System.Drawing.Size(1215, 138);
			this.panel3.TabIndex = 50;
			// 
			// txtTeleBunniesScored
			// 
			this.txtTeleBunniesScored.Location = new System.Drawing.Point(1113, 82);
			this.txtTeleBunniesScored.Margin = new System.Windows.Forms.Padding(2);
			this.txtTeleBunniesScored.Name = "txtTeleBunniesScored";
			this.txtTeleBunniesScored.Size = new System.Drawing.Size(74, 35);
			this.txtTeleBunniesScored.TabIndex = 44;
			this.txtTeleBunniesScored.Validating += new System.ComponentModel.CancelEventHandler(this.textbox_Validating);
			this.txtTeleBunniesScored.Validated += new System.EventHandler(this.textbox_Validated);
			// 
			// lblTeleBunniesScored
			// 
			this.lblTeleBunniesScored.AutoSize = true;
			this.lblTeleBunniesScored.Location = new System.Drawing.Point(919, 85);
			this.lblTeleBunniesScored.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
			this.lblTeleBunniesScored.Name = "lblTeleBunniesScored";
			this.lblTeleBunniesScored.Size = new System.Drawing.Size(190, 29);
			this.lblTeleBunniesScored.TabIndex = 49;
			this.lblTeleBunniesScored.Text = "Bunnies Scored:";
			// 
			// label11
			// 
			this.label11.AutoSize = true;
			this.label11.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Underline))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.label11.Location = new System.Drawing.Point(527, 22);
			this.label11.Margin = new System.Windows.Forms.Padding(7, 0, 7, 0);
			this.label11.Name = "label11";
			this.label11.Size = new System.Drawing.Size(141, 40);
			this.label11.TabIndex = 48;
			this.label11.Text = "TeleOp";
			// 
			// txtTeleBunniesStolen
			// 
			this.txtTeleBunniesStolen.Location = new System.Drawing.Point(819, 82);
			this.txtTeleBunniesStolen.Margin = new System.Windows.Forms.Padding(2);
			this.txtTeleBunniesStolen.Name = "txtTeleBunniesStolen";
			this.txtTeleBunniesStolen.Size = new System.Drawing.Size(74, 35);
			this.txtTeleBunniesStolen.TabIndex = 43;
			this.txtTeleBunniesStolen.Validating += new System.ComponentModel.CancelEventHandler(this.textbox_Validating);
			this.txtTeleBunniesStolen.Validated += new System.EventHandler(this.textbox_Validated);
			// 
			// lblTeleBunniesStolen
			// 
			this.lblTeleBunniesStolen.AutoSize = true;
			this.lblTeleBunniesStolen.Location = new System.Drawing.Point(637, 85);
			this.lblTeleBunniesStolen.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
			this.lblTeleBunniesStolen.Name = "lblTeleBunniesStolen";
			this.lblTeleBunniesStolen.Size = new System.Drawing.Size(181, 29);
			this.lblTeleBunniesStolen.TabIndex = 47;
			this.lblTeleBunniesStolen.Text = "Bunnies Stolen:";
			// 
			// txtTeleBunniesGround
			// 
			this.txtTeleBunniesGround.Location = new System.Drawing.Point(511, 82);
			this.txtTeleBunniesGround.Margin = new System.Windows.Forms.Padding(2);
			this.txtTeleBunniesGround.Name = "txtTeleBunniesGround";
			this.txtTeleBunniesGround.Size = new System.Drawing.Size(74, 35);
			this.txtTeleBunniesGround.TabIndex = 42;
			this.txtTeleBunniesGround.Validating += new System.ComponentModel.CancelEventHandler(this.textbox_Validating);
			this.txtTeleBunniesGround.Validated += new System.EventHandler(this.textbox_Validated);
			// 
			// lblTeleBunniesGround
			// 
			this.lblTeleBunniesGround.AutoSize = true;
			this.lblTeleBunniesGround.Location = new System.Drawing.Point(317, 85);
			this.lblTeleBunniesGround.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
			this.lblTeleBunniesGround.Name = "lblTeleBunniesGround";
			this.lblTeleBunniesGround.Size = new System.Drawing.Size(192, 29);
			this.lblTeleBunniesGround.TabIndex = 46;
			this.lblTeleBunniesGround.Text = "Bunnies Ground:";
			// 
			// txtTeleLinesCrossed
			// 
			this.txtTeleLinesCrossed.Location = new System.Drawing.Point(203, 82);
			this.txtTeleLinesCrossed.Margin = new System.Windows.Forms.Padding(2);
			this.txtTeleLinesCrossed.Name = "txtTeleLinesCrossed";
			this.txtTeleLinesCrossed.Size = new System.Drawing.Size(74, 35);
			this.txtTeleLinesCrossed.TabIndex = 41;
			this.txtTeleLinesCrossed.Validating += new System.ComponentModel.CancelEventHandler(this.textbox_Validating);
			this.txtTeleLinesCrossed.Validated += new System.EventHandler(this.textbox_Validated);
			// 
			// lblTeleLinesCrossed
			// 
			this.lblTeleLinesCrossed.AutoSize = true;
			this.lblTeleLinesCrossed.Location = new System.Drawing.Point(28, 85);
			this.lblTeleLinesCrossed.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
			this.lblTeleLinesCrossed.Name = "lblTeleLinesCrossed";
			this.lblTeleLinesCrossed.Size = new System.Drawing.Size(174, 29);
			this.lblTeleLinesCrossed.TabIndex = 45;
			this.lblTeleLinesCrossed.Text = "Lines Crossed:";
			// 
			// panel4
			// 
			this.panel4.Controls.Add(this.label15);
			this.panel4.Controls.Add(this.txtNerfShotsMissed);
			this.panel4.Controls.Add(this.lblNerfShotsMissed);
			this.panel4.Controls.Add(this.txtNerfShotsHit);
			this.panel4.Controls.Add(this.lblNerfShotsHit);
			this.panel4.Location = new System.Drawing.Point(14, 668);
			this.panel4.Name = "panel4";
			this.panel4.Size = new System.Drawing.Size(1215, 147);
			this.panel4.TabIndex = 51;
			// 
			// label15
			// 
			this.label15.AutoSize = true;
			this.label15.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Underline))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
			this.label15.Location = new System.Drawing.Point(525, 20);
			this.label15.Margin = new System.Windows.Forms.Padding(7, 0, 7, 0);
			this.label15.Name = "label15";
			this.label15.Size = new System.Drawing.Size(119, 40);
			this.label15.TabIndex = 51;
			this.label15.Text = "NERF";
			// 
			// txtNerfShotsMissed
			// 
			this.txtNerfShotsMissed.Location = new System.Drawing.Point(772, 92);
			this.txtNerfShotsMissed.Margin = new System.Windows.Forms.Padding(2);
			this.txtNerfShotsMissed.Name = "txtNerfShotsMissed";
			this.txtNerfShotsMissed.Size = new System.Drawing.Size(209, 35);
			this.txtNerfShotsMissed.TabIndex = 48;
			this.txtNerfShotsMissed.Validating += new System.ComponentModel.CancelEventHandler(this.textbox_Validating);
			this.txtNerfShotsMissed.Validated += new System.EventHandler(this.textbox_Validated);
			// 
			// lblNerfShotsMissed
			// 
			this.lblNerfShotsMissed.AutoSize = true;
			this.lblNerfShotsMissed.Location = new System.Drawing.Point(597, 94);
			this.lblNerfShotsMissed.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
			this.lblNerfShotsMissed.Name = "lblNerfShotsMissed";
			this.lblNerfShotsMissed.Size = new System.Drawing.Size(164, 29);
			this.lblNerfShotsMissed.TabIndex = 50;
			this.lblNerfShotsMissed.Text = "Shots Missed:";
			// 
			// txtNerfShotsHit
			// 
			this.txtNerfShotsHit.Location = new System.Drawing.Point(345, 92);
			this.txtNerfShotsHit.Margin = new System.Windows.Forms.Padding(2);
			this.txtNerfShotsHit.Name = "txtNerfShotsHit";
			this.txtNerfShotsHit.Size = new System.Drawing.Size(209, 35);
			this.txtNerfShotsHit.TabIndex = 47;
			this.txtNerfShotsHit.Validating += new System.ComponentModel.CancelEventHandler(this.textbox_Validating);
			this.txtNerfShotsHit.Validated += new System.EventHandler(this.textbox_Validated);
			// 
			// lblNerfShotsHit
			// 
			this.lblNerfShotsHit.AutoSize = true;
			this.lblNerfShotsHit.Location = new System.Drawing.Point(233, 94);
			this.lblNerfShotsHit.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
			this.lblNerfShotsHit.Name = "lblNerfShotsHit";
			this.lblNerfShotsHit.Size = new System.Drawing.Size(115, 29);
			this.lblNerfShotsHit.TabIndex = 49;
			this.lblNerfShotsHit.Text = "Shots Hit:";
			// 
			// panel5
			// 
			this.panel5.Controls.Add(this.chkBreakdownFlag);
			this.panel5.Controls.Add(this.chkDefenceFlag);
			this.panel5.Location = new System.Drawing.Point(14, 828);
			this.panel5.Name = "panel5";
			this.panel5.Size = new System.Drawing.Size(1215, 100);
			this.panel5.TabIndex = 52;
			// 
			// chkBreakdownFlag
			// 
			this.chkBreakdownFlag.AutoSize = true;
			this.chkBreakdownFlag.Location = new System.Drawing.Point(610, 34);
			this.chkBreakdownFlag.Margin = new System.Windows.Forms.Padding(2);
			this.chkBreakdownFlag.Name = "chkBreakdownFlag";
			this.chkBreakdownFlag.Size = new System.Drawing.Size(221, 33);
			this.chkBreakdownFlag.TabIndex = 17;
			this.chkBreakdownFlag.Text = "Breakdown Flag";
			this.chkBreakdownFlag.UseVisualStyleBackColor = true;
			// 
			// chkDefenceFlag
			// 
			this.chkDefenceFlag.AutoSize = true;
			this.chkDefenceFlag.Location = new System.Drawing.Point(384, 34);
			this.chkDefenceFlag.Margin = new System.Windows.Forms.Padding(2);
			this.chkDefenceFlag.Name = "chkDefenceFlag";
			this.chkDefenceFlag.Size = new System.Drawing.Size(189, 33);
			this.chkDefenceFlag.TabIndex = 16;
			this.chkDefenceFlag.Text = "Defence Flag";
			this.chkDefenceFlag.UseVisualStyleBackColor = true;
			// 
			// panel6
			// 
			this.panel6.Controls.Add(this.btnCancel);
			this.panel6.Controls.Add(this.btnSave);
			this.panel6.Location = new System.Drawing.Point(14, 942);
			this.panel6.Name = "panel6";
			this.panel6.Size = new System.Drawing.Size(1215, 100);
			this.panel6.TabIndex = 53;
			// 
			// btnCancel
			// 
			this.btnCancel.CausesValidation = false;
			this.btnCancel.DialogResult = System.Windows.Forms.DialogResult.Cancel;
			this.btnCancel.Location = new System.Drawing.Point(648, 7);
			this.btnCancel.Margin = new System.Windows.Forms.Padding(2);
			this.btnCancel.Name = "btnCancel";
			this.btnCancel.Size = new System.Drawing.Size(180, 87);
			this.btnCancel.TabIndex = 19;
			this.btnCancel.Text = "Cancel";
			this.btnCancel.UseVisualStyleBackColor = true;
			this.btnCancel.Click += new System.EventHandler(this.btnCancel_Click);
			// 
			// btnSave
			// 
			this.btnSave.Location = new System.Drawing.Point(387, 7);
			this.btnSave.Margin = new System.Windows.Forms.Padding(2);
			this.btnSave.Name = "btnSave";
			this.btnSave.Size = new System.Drawing.Size(180, 87);
			this.btnSave.TabIndex = 18;
			this.btnSave.Text = "Save";
			this.btnSave.UseVisualStyleBackColor = true;
			this.btnSave.Click += new System.EventHandler(this.btnSave_Click);
			// 
			// panel7
			// 
			this.panel7.Controls.Add(this.statusStrip1);
			this.panel7.Location = new System.Drawing.Point(13, 1049);
			this.panel7.Name = "panel7";
			this.panel7.Size = new System.Drawing.Size(1216, 49);
			this.panel7.TabIndex = 54;
			// 
			// statusStrip1
			// 
			this.statusStrip1.GripStyle = System.Windows.Forms.ToolStripGripStyle.Visible;
			this.statusStrip1.ImageScalingSize = new System.Drawing.Size(36, 36);
			this.statusStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.toolStripStatusLabel1});
			this.statusStrip1.Location = new System.Drawing.Point(0, 27);
			this.statusStrip1.Name = "statusStrip1";
			this.statusStrip1.Size = new System.Drawing.Size(1216, 22);
			this.statusStrip1.TabIndex = 48;
			this.statusStrip1.Text = "statusStrip1";
			// 
			// toolStripStatusLabel1
			// 
			this.toolStripStatusLabel1.Name = "toolStripStatusLabel1";
			this.toolStripStatusLabel1.Size = new System.Drawing.Size(0, 38);
			// 
			// TeamMatchActionEntryForm
			// 
			this.AutoScaleDimensions = new System.Drawing.SizeF(14F, 29F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.AutoSize = true;
			this.CausesValidation = false;
			this.ClientSize = new System.Drawing.Size(1241, 1110);
			this.Controls.Add(this.panel7);
			this.Controls.Add(this.panel6);
			this.Controls.Add(this.panel5);
			this.Controls.Add(this.panel4);
			this.Controls.Add(this.panel3);
			this.Controls.Add(this.panel2);
			this.Controls.Add(this.panel1);
			this.Controls.Add(this.lblAddAMatch);
			this.Controls.Add(this.txtScouter);
			this.Controls.Add(this.lblScouter);
			this.Margin = new System.Windows.Forms.Padding(2);
			this.Name = "TeamMatchActionEntryForm";
			this.Padding = new System.Windows.Forms.Padding(9);
			this.Text = "TeamMatchActionEntryForm";
			((System.ComponentModel.ISupportInitialize)(this.errorProvider1)).EndInit();
			this.panel1.ResumeLayout(false);
			this.panel1.PerformLayout();
			this.panel2.ResumeLayout(false);
			this.panel2.PerformLayout();
			this.panel3.ResumeLayout(false);
			this.panel3.PerformLayout();
			this.panel4.ResumeLayout(false);
			this.panel4.PerformLayout();
			this.panel5.ResumeLayout(false);
			this.panel5.PerformLayout();
			this.panel6.ResumeLayout(false);
			this.panel7.ResumeLayout(false);
			this.panel7.PerformLayout();
			this.statusStrip1.ResumeLayout(false);
			this.statusStrip1.PerformLayout();
			this.ResumeLayout(false);
			this.PerformLayout();

		}

		#endregion

		private System.Windows.Forms.Label lblScouter;
		private System.Windows.Forms.TextBox txtScouter;
		private System.Windows.Forms.Label lblAddAMatch;
		private System.Windows.Forms.ErrorProvider errorProvider1;
		private System.Windows.Forms.Panel panel1;
		private System.Windows.Forms.ComboBox cmbAllianceColor;
		private System.Windows.Forms.Label lblAllianceColor;
		private System.Windows.Forms.TextBox txtTeamNumber;
		private System.Windows.Forms.Label lblTeamNumnber;
		private System.Windows.Forms.TextBox txtMatchNumber;
		private System.Windows.Forms.Label lblMatchNumber;
		private System.Windows.Forms.Panel panel6;
		private System.Windows.Forms.Button btnCancel;
		private System.Windows.Forms.Button btnSave;
		private System.Windows.Forms.Panel panel5;
		private System.Windows.Forms.CheckBox chkBreakdownFlag;
		private System.Windows.Forms.CheckBox chkDefenceFlag;
		private System.Windows.Forms.Panel panel4;
		private System.Windows.Forms.Label label15;
		private System.Windows.Forms.TextBox txtNerfShotsMissed;
		private System.Windows.Forms.Label lblNerfShotsMissed;
		private System.Windows.Forms.TextBox txtNerfShotsHit;
		private System.Windows.Forms.Label lblNerfShotsHit;
		private System.Windows.Forms.Panel panel3;
		private System.Windows.Forms.TextBox txtTeleBunniesScored;
		private System.Windows.Forms.Label lblTeleBunniesScored;
		private System.Windows.Forms.Label label11;
		private System.Windows.Forms.TextBox txtTeleBunniesStolen;
		private System.Windows.Forms.Label lblTeleBunniesStolen;
		private System.Windows.Forms.TextBox txtTeleBunniesGround;
		private System.Windows.Forms.Label lblTeleBunniesGround;
		private System.Windows.Forms.TextBox txtTeleLinesCrossed;
		private System.Windows.Forms.Label lblTeleLinesCrossed;
		private System.Windows.Forms.Panel panel2;
		private System.Windows.Forms.Label lblBlueAlliance;
		private System.Windows.Forms.TextBox txtAutoBunniesScored;
		private System.Windows.Forms.Label lblAutoBunniesScored;
		private System.Windows.Forms.TextBox txtAutoBunniesPicked;
		private System.Windows.Forms.Label lblAutoBunniesPicked;
		private System.Windows.Forms.TextBox txtAutoLinesCrossed;
		private System.Windows.Forms.Label lblAutoLinesCrossed;
		private System.Windows.Forms.Panel panel7;
		private System.Windows.Forms.StatusStrip statusStrip1;
		private System.Windows.Forms.ToolStripStatusLabel toolStripStatusLabel1;
	}
}