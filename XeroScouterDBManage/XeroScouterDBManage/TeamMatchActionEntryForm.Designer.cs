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
            this.chkBaselineCross = new System.Windows.Forms.CheckBox();
            this.txtAutoFuelBinsTriggered = new System.Windows.Forms.TextBox();
            this.lblAutoFuelBinsTriggered = new System.Windows.Forms.Label();
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.lblAutoHighMissed = new System.Windows.Forms.Label();
            this.lblBlueAlliance = new System.Windows.Forms.Label();
            this.txtAutoGearsDelivered = new System.Windows.Forms.TextBox();
            this.lblAutoGearsDelivered = new System.Windows.Forms.Label();
            this.txtAutoHighScored = new System.Windows.Forms.TextBox();
            this.lblAutoHighScored = new System.Windows.Forms.Label();
            this.txtAutoLowDump = new System.Windows.Forms.TextBox();
            this.lblAutoLowDump = new System.Windows.Forms.Label();
            this.panel3 = new System.Windows.Forms.Panel();
            this.txtTeleGearsDelivered = new System.Windows.Forms.TextBox();
            this.lblTeleGearsDelivered = new System.Windows.Forms.Label();
            this.label11 = new System.Windows.Forms.Label();
            this.txtTeleHighMissed = new System.Windows.Forms.TextBox();
            this.lblTeleHighMissed = new System.Windows.Forms.Label();
            this.txtTeleHighScored = new System.Windows.Forms.TextBox();
            this.lblTeleHighScored = new System.Windows.Forms.Label();
            this.txtTeleLowDumps = new System.Windows.Forms.TextBox();
            this.lblTeleLowDumps = new System.Windows.Forms.Label();
            this.panel5 = new System.Windows.Forms.Panel();
            this.chkBreakdownFlag = new System.Windows.Forms.CheckBox();
            this.chkDefenceFlag = new System.Windows.Forms.CheckBox();
            this.panel6 = new System.Windows.Forms.Panel();
            this.btnCancel = new System.Windows.Forms.Button();
            this.btnSave = new System.Windows.Forms.Button();
            this.panel7 = new System.Windows.Forms.Panel();
            this.txtTeleFuelBinsTriggered = new System.Windows.Forms.TextBox();
            this.lblTeleFuelBinsTriggered = new System.Windows.Forms.Label();
            this.chkDisconnectFlag = new System.Windows.Forms.CheckBox();
            this.chkClimbAttempted = new System.Windows.Forms.CheckBox();
            this.chkClimbSuccess = new System.Windows.Forms.CheckBox();
            this.statusStrip1 = new System.Windows.Forms.StatusStrip();
            this.toolStripStatusLabel1 = new System.Windows.Forms.ToolStripStatusLabel();
            ((System.ComponentModel.ISupportInitialize)(this.errorProvider1)).BeginInit();
            this.panel1.SuspendLayout();
            this.panel2.SuspendLayout();
            this.panel3.SuspendLayout();
            this.panel5.SuspendLayout();
            this.panel6.SuspendLayout();
            this.panel7.SuspendLayout();
            this.statusStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // lblScouter
            // 
            this.lblScouter.AutoSize = true;
            this.lblScouter.Location = new System.Drawing.Point(128, 66);
            this.lblScouter.Margin = new System.Windows.Forms.Padding(1, 0, 1, 0);
            this.lblScouter.Name = "lblScouter";
            this.lblScouter.Size = new System.Drawing.Size(47, 13);
            this.lblScouter.TabIndex = 0;
            this.lblScouter.Text = "Scouter:";
            // 
            // txtScouter
            // 
            this.txtScouter.Location = new System.Drawing.Point(178, 65);
            this.txtScouter.Margin = new System.Windows.Forms.Padding(1);
            this.txtScouter.Name = "txtScouter";
            this.txtScouter.Size = new System.Drawing.Size(215, 20);
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
            this.lblAddAMatch.Location = new System.Drawing.Point(175, 22);
            this.lblAddAMatch.Name = "lblAddAMatch";
            this.lblAddAMatch.Size = new System.Drawing.Size(181, 29);
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
            this.panel1.Location = new System.Drawing.Point(6, 94);
            this.panel1.Margin = new System.Windows.Forms.Padding(1);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(521, 50);
            this.panel1.TabIndex = 48;
            // 
            // cmbAllianceColor
            // 
            this.cmbAllianceColor.FormattingEnabled = true;
            this.cmbAllianceColor.Items.AddRange(new object[] {
            "Blue",
            "Red"});
            this.cmbAllianceColor.Location = new System.Drawing.Point(418, 17);
            this.cmbAllianceColor.Margin = new System.Windows.Forms.Padding(1);
            this.cmbAllianceColor.Name = "cmbAllianceColor";
            this.cmbAllianceColor.Size = new System.Drawing.Size(81, 21);
            this.cmbAllianceColor.TabIndex = 10;
            // 
            // lblAllianceColor
            // 
            this.lblAllianceColor.AutoSize = true;
            this.lblAllianceColor.Location = new System.Drawing.Point(337, 18);
            this.lblAllianceColor.Margin = new System.Windows.Forms.Padding(1, 0, 1, 0);
            this.lblAllianceColor.Name = "lblAllianceColor";
            this.lblAllianceColor.Size = new System.Drawing.Size(74, 13);
            this.lblAllianceColor.TabIndex = 12;
            this.lblAllianceColor.Text = "Alliance Color:";
            // 
            // txtTeamNumber
            // 
            this.txtTeamNumber.Location = new System.Drawing.Point(229, 17);
            this.txtTeamNumber.Margin = new System.Windows.Forms.Padding(1);
            this.txtTeamNumber.Name = "txtTeamNumber";
            this.txtTeamNumber.Size = new System.Drawing.Size(92, 20);
            this.txtTeamNumber.TabIndex = 9;
            this.txtTeamNumber.Validating += new System.ComponentModel.CancelEventHandler(this.textbox_Validating);
            this.txtTeamNumber.Validated += new System.EventHandler(this.textbox_Validated);
            // 
            // lblTeamNumnber
            // 
            this.lblTeamNumnber.AutoSize = true;
            this.lblTeamNumnber.Location = new System.Drawing.Point(181, 18);
            this.lblTeamNumnber.Margin = new System.Windows.Forms.Padding(1, 0, 1, 0);
            this.lblTeamNumnber.Name = "lblTeamNumnber";
            this.lblTeamNumnber.Size = new System.Drawing.Size(44, 13);
            this.lblTeamNumnber.TabIndex = 11;
            this.lblTeamNumnber.Text = "Team#:";
            // 
            // txtMatchNumber
            // 
            this.txtMatchNumber.Location = new System.Drawing.Point(72, 17);
            this.txtMatchNumber.Margin = new System.Windows.Forms.Padding(1);
            this.txtMatchNumber.Name = "txtMatchNumber";
            this.txtMatchNumber.Size = new System.Drawing.Size(92, 20);
            this.txtMatchNumber.TabIndex = 7;
            this.txtMatchNumber.Validating += new System.ComponentModel.CancelEventHandler(this.textbox_Validating);
            this.txtMatchNumber.Validated += new System.EventHandler(this.textbox_Validated);
            // 
            // lblMatchNumber
            // 
            this.lblMatchNumber.AutoSize = true;
            this.lblMatchNumber.Location = new System.Drawing.Point(24, 18);
            this.lblMatchNumber.Margin = new System.Windows.Forms.Padding(1, 0, 1, 0);
            this.lblMatchNumber.Name = "lblMatchNumber";
            this.lblMatchNumber.Size = new System.Drawing.Size(47, 13);
            this.lblMatchNumber.TabIndex = 8;
            this.lblMatchNumber.Text = "Match#:";
            // 
            // panel2
            // 
            this.panel2.Controls.Add(this.chkBaselineCross);
            this.panel2.Controls.Add(this.txtAutoFuelBinsTriggered);
            this.panel2.Controls.Add(this.lblAutoFuelBinsTriggered);
            this.panel2.Controls.Add(this.textBox1);
            this.panel2.Controls.Add(this.lblAutoHighMissed);
            this.panel2.Controls.Add(this.lblBlueAlliance);
            this.panel2.Controls.Add(this.txtAutoGearsDelivered);
            this.panel2.Controls.Add(this.lblAutoGearsDelivered);
            this.panel2.Controls.Add(this.txtAutoHighScored);
            this.panel2.Controls.Add(this.lblAutoHighScored);
            this.panel2.Controls.Add(this.txtAutoLowDump);
            this.panel2.Controls.Add(this.lblAutoLowDump);
            this.panel2.Location = new System.Drawing.Point(6, 146);
            this.panel2.Margin = new System.Windows.Forms.Padding(1);
            this.panel2.Name = "panel2";
            this.panel2.Size = new System.Drawing.Size(521, 96);
            this.panel2.TabIndex = 49;
            // 
            // chkBaselineCross
            // 
            this.chkBaselineCross.AutoSize = true;
            this.chkBaselineCross.Location = new System.Drawing.Point(27, 35);
            this.chkBaselineCross.Name = "chkBaselineCross";
            this.chkBaselineCross.Size = new System.Drawing.Size(95, 17);
            this.chkBaselineCross.TabIndex = 50;
            this.chkBaselineCross.Text = "Baseline Cross";
            this.chkBaselineCross.UseVisualStyleBackColor = true;
            // 
            // txtAutoFuelBinsTriggered
            // 
            this.txtAutoFuelBinsTriggered.Location = new System.Drawing.Point(436, 65);
            this.txtAutoFuelBinsTriggered.Margin = new System.Windows.Forms.Padding(1);
            this.txtAutoFuelBinsTriggered.Name = "txtAutoFuelBinsTriggered";
            this.txtAutoFuelBinsTriggered.Size = new System.Drawing.Size(63, 20);
            this.txtAutoFuelBinsTriggered.TabIndex = 48;
            // 
            // lblAutoFuelBinsTriggered
            // 
            this.lblAutoFuelBinsTriggered.AutoSize = true;
            this.lblAutoFuelBinsTriggered.Location = new System.Drawing.Point(337, 68);
            this.lblAutoFuelBinsTriggered.Margin = new System.Windows.Forms.Padding(1, 0, 1, 0);
            this.lblAutoFuelBinsTriggered.Name = "lblAutoFuelBinsTriggered";
            this.lblAutoFuelBinsTriggered.Size = new System.Drawing.Size(101, 13);
            this.lblAutoFuelBinsTriggered.TabIndex = 49;
            this.lblAutoFuelBinsTriggered.Text = "Fuel Bins Triggered:";
            // 
            // textBox1
            // 
            this.textBox1.Location = new System.Drawing.Point(87, 65);
            this.textBox1.Margin = new System.Windows.Forms.Padding(1);
            this.textBox1.Name = "textBox1";
            this.textBox1.Size = new System.Drawing.Size(59, 20);
            this.textBox1.TabIndex = 46;
            // 
            // lblAutoHighMissed
            // 
            this.lblAutoHighMissed.AutoSize = true;
            this.lblAutoHighMissed.Location = new System.Drawing.Point(17, 69);
            this.lblAutoHighMissed.Margin = new System.Windows.Forms.Padding(1, 0, 1, 0);
            this.lblAutoHighMissed.Name = "lblAutoHighMissed";
            this.lblAutoHighMissed.Size = new System.Drawing.Size(68, 13);
            this.lblAutoHighMissed.TabIndex = 47;
            this.lblAutoHighMissed.Text = "High Missed:";
            // 
            // lblBlueAlliance
            // 
            this.lblBlueAlliance.AutoSize = true;
            this.lblBlueAlliance.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Underline))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblBlueAlliance.Location = new System.Drawing.Point(236, 6);
            this.lblBlueAlliance.Name = "lblBlueAlliance";
            this.lblBlueAlliance.Size = new System.Drawing.Size(47, 20);
            this.lblBlueAlliance.TabIndex = 45;
            this.lblBlueAlliance.Text = "Auto";
            // 
            // txtAutoGearsDelivered
            // 
            this.txtAutoGearsDelivered.Location = new System.Drawing.Point(261, 65);
            this.txtAutoGearsDelivered.Margin = new System.Windows.Forms.Padding(1);
            this.txtAutoGearsDelivered.Name = "txtAutoGearsDelivered";
            this.txtAutoGearsDelivered.Size = new System.Drawing.Size(63, 20);
            this.txtAutoGearsDelivered.TabIndex = 41;
            this.txtAutoGearsDelivered.Validating += new System.ComponentModel.CancelEventHandler(this.textbox_Validating);
            this.txtAutoGearsDelivered.Validated += new System.EventHandler(this.textbox_Validated);
            // 
            // lblAutoGearsDelivered
            // 
            this.lblAutoGearsDelivered.AutoSize = true;
            this.lblAutoGearsDelivered.Location = new System.Drawing.Point(177, 68);
            this.lblAutoGearsDelivered.Margin = new System.Windows.Forms.Padding(1, 0, 1, 0);
            this.lblAutoGearsDelivered.Name = "lblAutoGearsDelivered";
            this.lblAutoGearsDelivered.Size = new System.Drawing.Size(86, 13);
            this.lblAutoGearsDelivered.TabIndex = 44;
            this.lblAutoGearsDelivered.Text = "Gears Delivered:";
            // 
            // txtAutoHighScored
            // 
            this.txtAutoHighScored.Location = new System.Drawing.Point(440, 33);
            this.txtAutoHighScored.Margin = new System.Windows.Forms.Padding(1);
            this.txtAutoHighScored.Name = "txtAutoHighScored";
            this.txtAutoHighScored.Size = new System.Drawing.Size(59, 20);
            this.txtAutoHighScored.TabIndex = 40;
            this.txtAutoHighScored.Validating += new System.ComponentModel.CancelEventHandler(this.textbox_Validating);
            this.txtAutoHighScored.Validated += new System.EventHandler(this.textbox_Validated);
            // 
            // lblAutoHighScored
            // 
            this.lblAutoHighScored.AutoSize = true;
            this.lblAutoHighScored.Location = new System.Drawing.Point(370, 37);
            this.lblAutoHighScored.Margin = new System.Windows.Forms.Padding(1, 0, 1, 0);
            this.lblAutoHighScored.Name = "lblAutoHighScored";
            this.lblAutoHighScored.Size = new System.Drawing.Size(69, 13);
            this.lblAutoHighScored.TabIndex = 43;
            this.lblAutoHighScored.Text = "High Scored:";
            // 
            // txtAutoLowDump
            // 
            this.txtAutoLowDump.Location = new System.Drawing.Point(257, 32);
            this.txtAutoLowDump.Margin = new System.Windows.Forms.Padding(1);
            this.txtAutoLowDump.Name = "txtAutoLowDump";
            this.txtAutoLowDump.Size = new System.Drawing.Size(65, 20);
            this.txtAutoLowDump.TabIndex = 39;
            this.txtAutoLowDump.TextChanged += new System.EventHandler(this.txtAutoLowDump_TextChanged);
            this.txtAutoLowDump.Validating += new System.ComponentModel.CancelEventHandler(this.textbox_Validating);
            this.txtAutoLowDump.Validated += new System.EventHandler(this.textbox_Validated);
            // 
            // lblAutoLowDump
            // 
            this.lblAutoLowDump.AutoSize = true;
            this.lblAutoLowDump.Location = new System.Drawing.Point(194, 35);
            this.lblAutoLowDump.Margin = new System.Windows.Forms.Padding(1, 0, 1, 0);
            this.lblAutoLowDump.Name = "lblAutoLowDump";
            this.lblAutoLowDump.Size = new System.Drawing.Size(61, 13);
            this.lblAutoLowDump.TabIndex = 42;
            this.lblAutoLowDump.Text = "Low Dump:";
            // 
            // panel3
            // 
            this.panel3.Controls.Add(this.txtTeleFuelBinsTriggered);
            this.panel3.Controls.Add(this.lblTeleFuelBinsTriggered);
            this.panel3.Controls.Add(this.txtTeleGearsDelivered);
            this.panel3.Controls.Add(this.lblTeleGearsDelivered);
            this.panel3.Controls.Add(this.label11);
            this.panel3.Controls.Add(this.txtTeleHighMissed);
            this.panel3.Controls.Add(this.lblTeleHighMissed);
            this.panel3.Controls.Add(this.txtTeleHighScored);
            this.panel3.Controls.Add(this.lblTeleHighScored);
            this.panel3.Controls.Add(this.txtTeleLowDumps);
            this.panel3.Controls.Add(this.lblTeleLowDumps);
            this.panel3.Location = new System.Drawing.Point(6, 244);
            this.panel3.Margin = new System.Windows.Forms.Padding(1);
            this.panel3.Name = "panel3";
            this.panel3.Size = new System.Drawing.Size(521, 118);
            this.panel3.TabIndex = 50;
            // 
            // txtTeleGearsDelivered
            // 
            this.txtTeleGearsDelivered.Location = new System.Drawing.Point(260, 85);
            this.txtTeleGearsDelivered.Margin = new System.Windows.Forms.Padding(1);
            this.txtTeleGearsDelivered.Name = "txtTeleGearsDelivered";
            this.txtTeleGearsDelivered.Size = new System.Drawing.Size(34, 20);
            this.txtTeleGearsDelivered.TabIndex = 44;
            this.txtTeleGearsDelivered.Validating += new System.ComponentModel.CancelEventHandler(this.textbox_Validating);
            this.txtTeleGearsDelivered.Validated += new System.EventHandler(this.textbox_Validated);
            // 
            // lblTeleGearsDelivered
            // 
            this.lblTeleGearsDelivered.AutoSize = true;
            this.lblTeleGearsDelivered.Location = new System.Drawing.Point(177, 86);
            this.lblTeleGearsDelivered.Margin = new System.Windows.Forms.Padding(1, 0, 1, 0);
            this.lblTeleGearsDelivered.Name = "lblTeleGearsDelivered";
            this.lblTeleGearsDelivered.Size = new System.Drawing.Size(86, 13);
            this.lblTeleGearsDelivered.TabIndex = 49;
            this.lblTeleGearsDelivered.Text = "Gears Delivered:";
            // 
            // label11
            // 
            this.label11.AutoSize = true;
            this.label11.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Underline))), System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label11.Location = new System.Drawing.Point(226, 10);
            this.label11.Name = "label11";
            this.label11.Size = new System.Drawing.Size(66, 20);
            this.label11.TabIndex = 48;
            this.label11.Text = "TeleOp";
            // 
            // txtTeleHighMissed
            // 
            this.txtTeleHighMissed.Location = new System.Drawing.Point(88, 85);
            this.txtTeleHighMissed.Margin = new System.Windows.Forms.Padding(1);
            this.txtTeleHighMissed.Name = "txtTeleHighMissed";
            this.txtTeleHighMissed.Size = new System.Drawing.Size(34, 20);
            this.txtTeleHighMissed.TabIndex = 43;
            this.txtTeleHighMissed.Validating += new System.ComponentModel.CancelEventHandler(this.textbox_Validating);
            this.txtTeleHighMissed.Validated += new System.EventHandler(this.textbox_Validated);
            // 
            // lblTeleHighMissed
            // 
            this.lblTeleHighMissed.AutoSize = true;
            this.lblTeleHighMissed.Location = new System.Drawing.Point(10, 89);
            this.lblTeleHighMissed.Margin = new System.Windows.Forms.Padding(1, 0, 1, 0);
            this.lblTeleHighMissed.Name = "lblTeleHighMissed";
            this.lblTeleHighMissed.Size = new System.Drawing.Size(68, 13);
            this.lblTeleHighMissed.TabIndex = 47;
            this.lblTeleHighMissed.Text = "High Missed:";
            // 
            // txtTeleHighScored
            // 
            this.txtTeleHighScored.Location = new System.Drawing.Point(436, 46);
            this.txtTeleHighScored.Margin = new System.Windows.Forms.Padding(1);
            this.txtTeleHighScored.Name = "txtTeleHighScored";
            this.txtTeleHighScored.Size = new System.Drawing.Size(34, 20);
            this.txtTeleHighScored.TabIndex = 42;
            this.txtTeleHighScored.Validating += new System.ComponentModel.CancelEventHandler(this.textbox_Validating);
            this.txtTeleHighScored.Validated += new System.EventHandler(this.textbox_Validated);
            // 
            // lblTeleHighScored
            // 
            this.lblTeleHighScored.AutoSize = true;
            this.lblTeleHighScored.Location = new System.Drawing.Point(353, 50);
            this.lblTeleHighScored.Margin = new System.Windows.Forms.Padding(1, 0, 1, 0);
            this.lblTeleHighScored.Name = "lblTeleHighScored";
            this.lblTeleHighScored.Size = new System.Drawing.Size(69, 13);
            this.lblTeleHighScored.TabIndex = 46;
            this.lblTeleHighScored.Text = "High Scored:";
            // 
            // txtTeleLowDumps
            // 
            this.txtTeleLowDumps.Location = new System.Drawing.Point(267, 46);
            this.txtTeleLowDumps.Margin = new System.Windows.Forms.Padding(1);
            this.txtTeleLowDumps.Name = "txtTeleLowDumps";
            this.txtTeleLowDumps.Size = new System.Drawing.Size(34, 20);
            this.txtTeleLowDumps.TabIndex = 41;
            this.txtTeleLowDumps.Validating += new System.ComponentModel.CancelEventHandler(this.textbox_Validating);
            this.txtTeleLowDumps.Validated += new System.EventHandler(this.textbox_Validated);
            // 
            // lblTeleLowDumps
            // 
            this.lblTeleLowDumps.AutoSize = true;
            this.lblTeleLowDumps.Location = new System.Drawing.Point(192, 50);
            this.lblTeleLowDumps.Margin = new System.Windows.Forms.Padding(1, 0, 1, 0);
            this.lblTeleLowDumps.Name = "lblTeleLowDumps";
            this.lblTeleLowDumps.Size = new System.Drawing.Size(66, 13);
            this.lblTeleLowDumps.TabIndex = 45;
            this.lblTeleLowDumps.Text = "Low Dumps:";
            // 
            // panel5
            // 
            this.panel5.Controls.Add(this.chkClimbSuccess);
            this.panel5.Controls.Add(this.chkClimbAttempted);
            this.panel5.Controls.Add(this.chkDisconnectFlag);
            this.panel5.Controls.Add(this.chkBreakdownFlag);
            this.panel5.Controls.Add(this.chkDefenceFlag);
            this.panel5.Location = new System.Drawing.Point(6, 364);
            this.panel5.Margin = new System.Windows.Forms.Padding(1);
            this.panel5.Name = "panel5";
            this.panel5.Size = new System.Drawing.Size(521, 45);
            this.panel5.TabIndex = 52;
            // 
            // chkBreakdownFlag
            // 
            this.chkBreakdownFlag.AutoSize = true;
            this.chkBreakdownFlag.Location = new System.Drawing.Point(339, 14);
            this.chkBreakdownFlag.Margin = new System.Windows.Forms.Padding(1);
            this.chkBreakdownFlag.Name = "chkBreakdownFlag";
            this.chkBreakdownFlag.Size = new System.Drawing.Size(80, 17);
            this.chkBreakdownFlag.TabIndex = 17;
            this.chkBreakdownFlag.Text = "Breakdown";
            this.chkBreakdownFlag.UseVisualStyleBackColor = true;
            this.chkBreakdownFlag.CheckedChanged += new System.EventHandler(this.chkBreakdownFlag_CheckedChanged);
            // 
            // chkDefenceFlag
            // 
            this.chkDefenceFlag.AutoSize = true;
            this.chkDefenceFlag.Location = new System.Drawing.Point(243, 14);
            this.chkDefenceFlag.Margin = new System.Windows.Forms.Padding(1);
            this.chkDefenceFlag.Name = "chkDefenceFlag";
            this.chkDefenceFlag.Size = new System.Drawing.Size(67, 17);
            this.chkDefenceFlag.TabIndex = 16;
            this.chkDefenceFlag.Text = "Defence";
            this.chkDefenceFlag.UseVisualStyleBackColor = true;
            this.chkDefenceFlag.CheckedChanged += new System.EventHandler(this.chkDefenceFlag_CheckedChanged);
            // 
            // panel6
            // 
            this.panel6.Controls.Add(this.btnCancel);
            this.panel6.Controls.Add(this.btnSave);
            this.panel6.Location = new System.Drawing.Point(6, 411);
            this.panel6.Margin = new System.Windows.Forms.Padding(1);
            this.panel6.Name = "panel6";
            this.panel6.Size = new System.Drawing.Size(521, 45);
            this.panel6.TabIndex = 53;
            // 
            // btnCancel
            // 
            this.btnCancel.CausesValidation = false;
            this.btnCancel.DialogResult = System.Windows.Forms.DialogResult.Cancel;
            this.btnCancel.Location = new System.Drawing.Point(278, 3);
            this.btnCancel.Margin = new System.Windows.Forms.Padding(1);
            this.btnCancel.Name = "btnCancel";
            this.btnCancel.Size = new System.Drawing.Size(77, 39);
            this.btnCancel.TabIndex = 19;
            this.btnCancel.Text = "Cancel";
            this.btnCancel.UseVisualStyleBackColor = true;
            this.btnCancel.Click += new System.EventHandler(this.btnCancel_Click);
            // 
            // btnSave
            // 
            this.btnSave.Location = new System.Drawing.Point(166, 3);
            this.btnSave.Margin = new System.Windows.Forms.Padding(1);
            this.btnSave.Name = "btnSave";
            this.btnSave.Size = new System.Drawing.Size(77, 39);
            this.btnSave.TabIndex = 18;
            this.btnSave.Text = "Save";
            this.btnSave.UseVisualStyleBackColor = true;
            this.btnSave.Click += new System.EventHandler(this.btnSave_Click);
            // 
            // panel7
            // 
            this.panel7.Controls.Add(this.statusStrip1);
            this.panel7.Location = new System.Drawing.Point(6, 458);
            this.panel7.Margin = new System.Windows.Forms.Padding(1);
            this.panel7.Name = "panel7";
            this.panel7.Size = new System.Drawing.Size(521, 22);
            this.panel7.TabIndex = 54;
            // 
            // txtTeleFuelBinsTriggered
            // 
            this.txtTeleFuelBinsTriggered.Location = new System.Drawing.Point(441, 87);
            this.txtTeleFuelBinsTriggered.Margin = new System.Windows.Forms.Padding(1);
            this.txtTeleFuelBinsTriggered.Name = "txtTeleFuelBinsTriggered";
            this.txtTeleFuelBinsTriggered.Size = new System.Drawing.Size(34, 20);
            this.txtTeleFuelBinsTriggered.TabIndex = 50;
            // 
            // lblTeleFuelBinsTriggered
            // 
            this.lblTeleFuelBinsTriggered.AutoSize = true;
            this.lblTeleFuelBinsTriggered.Location = new System.Drawing.Point(342, 88);
            this.lblTeleFuelBinsTriggered.Margin = new System.Windows.Forms.Padding(1, 0, 1, 0);
            this.lblTeleFuelBinsTriggered.Name = "lblTeleFuelBinsTriggered";
            this.lblTeleFuelBinsTriggered.Size = new System.Drawing.Size(101, 13);
            this.lblTeleFuelBinsTriggered.TabIndex = 51;
            this.lblTeleFuelBinsTriggered.Text = "Fuel Bins Triggered:";
            // 
            // chkDisconnectFlag
            // 
            this.chkDisconnectFlag.AutoSize = true;
            this.chkDisconnectFlag.Location = new System.Drawing.Point(436, 14);
            this.chkDisconnectFlag.Margin = new System.Windows.Forms.Padding(1);
            this.chkDisconnectFlag.Name = "chkDisconnectFlag";
            this.chkDisconnectFlag.Size = new System.Drawing.Size(80, 17);
            this.chkDisconnectFlag.TabIndex = 18;
            this.chkDisconnectFlag.Text = "Disconnect";
            this.chkDisconnectFlag.UseVisualStyleBackColor = true;
            this.chkDisconnectFlag.CheckedChanged += new System.EventHandler(this.chkDisconnectFlag_CheckedChanged);
            // 
            // chkClimbAttempted
            // 
            this.chkClimbAttempted.AutoSize = true;
            this.chkClimbAttempted.Location = new System.Drawing.Point(11, 14);
            this.chkClimbAttempted.Margin = new System.Windows.Forms.Padding(1);
            this.chkClimbAttempted.Name = "chkClimbAttempted";
            this.chkClimbAttempted.Size = new System.Drawing.Size(102, 17);
            this.chkClimbAttempted.TabIndex = 19;
            this.chkClimbAttempted.Text = "Climb Attempted";
            this.chkClimbAttempted.UseVisualStyleBackColor = true;
            // 
            // chkClimbSuccess
            // 
            this.chkClimbSuccess.AutoSize = true;
            this.chkClimbSuccess.Location = new System.Drawing.Point(125, 14);
            this.chkClimbSuccess.Margin = new System.Windows.Forms.Padding(1);
            this.chkClimbSuccess.Name = "chkClimbSuccess";
            this.chkClimbSuccess.Size = new System.Drawing.Size(106, 17);
            this.chkClimbSuccess.TabIndex = 20;
            this.chkClimbSuccess.Text = "Climb Successful";
            this.chkClimbSuccess.UseVisualStyleBackColor = true;
            // 
            // statusStrip1
            // 
            this.statusStrip1.GripStyle = System.Windows.Forms.ToolStripGripStyle.Visible;
            this.statusStrip1.ImageScalingSize = new System.Drawing.Size(36, 36);
            this.statusStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.toolStripStatusLabel1});
            this.statusStrip1.Location = new System.Drawing.Point(0, 0);
            this.statusStrip1.Name = "statusStrip1";
            this.statusStrip1.Padding = new System.Windows.Forms.Padding(0, 0, 6, 0);
            this.statusStrip1.Size = new System.Drawing.Size(521, 22);
            this.statusStrip1.TabIndex = 50;
            this.statusStrip1.Text = "statusStrip1";
            // 
            // toolStripStatusLabel1
            // 
            this.toolStripStatusLabel1.Name = "toolStripStatusLabel1";
            this.toolStripStatusLabel1.Size = new System.Drawing.Size(0, 0);
            // 
            // TeamMatchActionEntryForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoSize = true;
            this.CausesValidation = false;
            this.ClientSize = new System.Drawing.Size(532, 489);
            this.Controls.Add(this.panel7);
            this.Controls.Add(this.panel6);
            this.Controls.Add(this.panel5);
            this.Controls.Add(this.panel3);
            this.Controls.Add(this.panel2);
            this.Controls.Add(this.panel1);
            this.Controls.Add(this.lblAddAMatch);
            this.Controls.Add(this.txtScouter);
            this.Controls.Add(this.lblScouter);
            this.Margin = new System.Windows.Forms.Padding(1);
            this.Name = "TeamMatchActionEntryForm";
            this.Padding = new System.Windows.Forms.Padding(4);
            this.Text = "TeamMatchActionEntryForm";
            ((System.ComponentModel.ISupportInitialize)(this.errorProvider1)).EndInit();
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            this.panel2.ResumeLayout(false);
            this.panel2.PerformLayout();
            this.panel3.ResumeLayout(false);
            this.panel3.PerformLayout();
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
		private System.Windows.Forms.Panel panel3;
		private System.Windows.Forms.TextBox txtTeleGearsDelivered;
		private System.Windows.Forms.Label lblTeleGearsDelivered;
		private System.Windows.Forms.Label label11;
		private System.Windows.Forms.TextBox txtTeleHighMissed;
		private System.Windows.Forms.Label lblTeleHighMissed;
		private System.Windows.Forms.TextBox txtTeleHighScored;
		private System.Windows.Forms.Label lblTeleHighScored;
		private System.Windows.Forms.TextBox txtTeleLowDumps;
		private System.Windows.Forms.Label lblTeleLowDumps;
		private System.Windows.Forms.Panel panel2;
		private System.Windows.Forms.Label lblBlueAlliance;
		private System.Windows.Forms.TextBox txtAutoGearsDelivered;
		private System.Windows.Forms.Label lblAutoGearsDelivered;
		private System.Windows.Forms.TextBox txtAutoHighScored;
		private System.Windows.Forms.Label lblAutoHighScored;
		private System.Windows.Forms.TextBox txtAutoLowDump;
		private System.Windows.Forms.Label lblAutoLowDump;
		private System.Windows.Forms.Panel panel7;
        private System.Windows.Forms.TextBox txtAutoFuelBinsTriggered;
        private System.Windows.Forms.Label lblAutoFuelBinsTriggered;
        private System.Windows.Forms.TextBox textBox1;
        private System.Windows.Forms.Label lblAutoHighMissed;
        private System.Windows.Forms.CheckBox chkBaselineCross;
        private System.Windows.Forms.TextBox txtTeleFuelBinsTriggered;
        private System.Windows.Forms.Label lblTeleFuelBinsTriggered;
        private System.Windows.Forms.CheckBox chkDisconnectFlag;
        private System.Windows.Forms.CheckBox chkClimbSuccess;
        private System.Windows.Forms.CheckBox chkClimbAttempted;
        private System.Windows.Forms.StatusStrip statusStrip1;
        private System.Windows.Forms.ToolStripStatusLabel toolStripStatusLabel1;
    }
}