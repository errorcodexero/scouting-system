namespace XeroScouterDBManage_Server
{
	partial class TeamMatchActionEntryForm_BunnyBots2017
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
            this.txtAutoMidlineCross = new System.Windows.Forms.TextBox();
            this.lblAutoMidlineCross = new System.Windows.Forms.Label();
            this.txtAutoNearBucketLift = new System.Windows.Forms.TextBox();
            this.lblAutoNearBucketLift = new System.Windows.Forms.Label();
            this.lblBlueAlliance = new System.Windows.Forms.Label();
            this.txtAutoFarBucketLift = new System.Windows.Forms.TextBox();
            this.lblAutoFarBucketLift = new System.Windows.Forms.Label();
            this.panel3 = new System.Windows.Forms.Panel();
            this.chkDisconnectFlag = new System.Windows.Forms.CheckBox();
            this.txtTeleBunniesPlaced = new System.Windows.Forms.TextBox();
            this.chkBreakdownFlag = new System.Windows.Forms.CheckBox();
            this.lblTeleBunniesPlaced = new System.Windows.Forms.Label();
            this.chkDefenceFlag = new System.Windows.Forms.CheckBox();
            this.txtTeleBunniesPickedUp = new System.Windows.Forms.TextBox();
            this.lblTeleBunniesPickedUp = new System.Windows.Forms.Label();
            this.label11 = new System.Windows.Forms.Label();
            this.txtTeleBucketsSearched = new System.Windows.Forms.TextBox();
            this.lblTeleBucketsSearched = new System.Windows.Forms.Label();
            this.txtTeleBunniesFound = new System.Windows.Forms.TextBox();
            this.lblTeleBunniesFound = new System.Windows.Forms.Label();
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
            this.cmbAllianceColor.TabIndex = 24;
            this.cmbAllianceColor.TabStop = false;
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
            this.txtTeamNumber.TabIndex = 23;
            this.txtTeamNumber.TabStop = false;
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
            this.txtMatchNumber.TabIndex = 22;
            this.txtMatchNumber.TabStop = false;
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
            this.panel2.Controls.Add(this.txtAutoMidlineCross);
            this.panel2.Controls.Add(this.lblAutoMidlineCross);
            this.panel2.Controls.Add(this.txtAutoNearBucketLift);
            this.panel2.Controls.Add(this.lblAutoNearBucketLift);
            this.panel2.Controls.Add(this.lblBlueAlliance);
            this.panel2.Controls.Add(this.txtAutoFarBucketLift);
            this.panel2.Controls.Add(this.lblAutoFarBucketLift);
            this.panel2.Location = new System.Drawing.Point(6, 146);
            this.panel2.Margin = new System.Windows.Forms.Padding(1);
            this.panel2.Name = "panel2";
            this.panel2.Size = new System.Drawing.Size(521, 72);
            this.panel2.TabIndex = 49;
            // 
            // txtAutoMidlineCross
            // 
            this.txtAutoMidlineCross.Location = new System.Drawing.Point(439, 39);
            this.txtAutoMidlineCross.Margin = new System.Windows.Forms.Padding(1);
            this.txtAutoMidlineCross.Name = "txtAutoMidlineCross";
            this.txtAutoMidlineCross.Size = new System.Drawing.Size(63, 20);
            this.txtAutoMidlineCross.TabIndex = 7;
            this.txtAutoMidlineCross.Validating += new System.ComponentModel.CancelEventHandler(this.textbox_Validating);
            this.txtAutoMidlineCross.Validated += new System.EventHandler(this.textbox_Validated);
            // 
            // lblAutoMidlineCross
            // 
            this.lblAutoMidlineCross.AutoSize = true;
            this.lblAutoMidlineCross.Location = new System.Drawing.Point(365, 42);
            this.lblAutoMidlineCross.Margin = new System.Windows.Forms.Padding(1, 0, 1, 0);
            this.lblAutoMidlineCross.Name = "lblAutoMidlineCross";
            this.lblAutoMidlineCross.Size = new System.Drawing.Size(72, 13);
            this.lblAutoMidlineCross.TabIndex = 49;
            this.lblAutoMidlineCross.Text = "Midline Cross:";
            // 
            // txtAutoNearBucketLift
            // 
            this.txtAutoNearBucketLift.Location = new System.Drawing.Point(107, 39);
            this.txtAutoNearBucketLift.Margin = new System.Windows.Forms.Padding(1);
            this.txtAutoNearBucketLift.Name = "txtAutoNearBucketLift";
            this.txtAutoNearBucketLift.Size = new System.Drawing.Size(61, 20);
            this.txtAutoNearBucketLift.TabIndex = 5;
            this.txtAutoNearBucketLift.Validating += new System.ComponentModel.CancelEventHandler(this.textbox_Validating);
            this.txtAutoNearBucketLift.Validated += new System.EventHandler(this.textbox_Validated);
            // 
            // lblAutoNearBucketLift
            // 
            this.lblAutoNearBucketLift.AutoSize = true;
            this.lblAutoNearBucketLift.Location = new System.Drawing.Point(18, 43);
            this.lblAutoNearBucketLift.Margin = new System.Windows.Forms.Padding(1, 0, 1, 0);
            this.lblAutoNearBucketLift.Name = "lblAutoNearBucketLift";
            this.lblAutoNearBucketLift.Size = new System.Drawing.Size(87, 13);
            this.lblAutoNearBucketLift.TabIndex = 47;
            this.lblAutoNearBucketLift.Text = "Near Bucket Lift:";
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
            // txtAutoFarBucketLift
            // 
            this.txtAutoFarBucketLift.Location = new System.Drawing.Point(277, 39);
            this.txtAutoFarBucketLift.Margin = new System.Windows.Forms.Padding(1);
            this.txtAutoFarBucketLift.Name = "txtAutoFarBucketLift";
            this.txtAutoFarBucketLift.Size = new System.Drawing.Size(63, 20);
            this.txtAutoFarBucketLift.TabIndex = 6;
            this.txtAutoFarBucketLift.Validating += new System.ComponentModel.CancelEventHandler(this.textbox_Validating);
            this.txtAutoFarBucketLift.Validated += new System.EventHandler(this.textbox_Validated);
            // 
            // lblAutoFarBucketLift
            // 
            this.lblAutoFarBucketLift.AutoSize = true;
            this.lblAutoFarBucketLift.Location = new System.Drawing.Point(196, 42);
            this.lblAutoFarBucketLift.Margin = new System.Windows.Forms.Padding(1, 0, 1, 0);
            this.lblAutoFarBucketLift.Name = "lblAutoFarBucketLift";
            this.lblAutoFarBucketLift.Size = new System.Drawing.Size(79, 13);
            this.lblAutoFarBucketLift.TabIndex = 44;
            this.lblAutoFarBucketLift.Text = "Far Bucket Lift:";
            // 
            // panel3
            // 
            this.panel3.Controls.Add(this.chkDisconnectFlag);
            this.panel3.Controls.Add(this.txtTeleBunniesPlaced);
            this.panel3.Controls.Add(this.chkBreakdownFlag);
            this.panel3.Controls.Add(this.lblTeleBunniesPlaced);
            this.panel3.Controls.Add(this.chkDefenceFlag);
            this.panel3.Controls.Add(this.txtTeleBunniesPickedUp);
            this.panel3.Controls.Add(this.lblTeleBunniesPickedUp);
            this.panel3.Controls.Add(this.label11);
            this.panel3.Controls.Add(this.txtTeleBucketsSearched);
            this.panel3.Controls.Add(this.lblTeleBucketsSearched);
            this.panel3.Controls.Add(this.txtTeleBunniesFound);
            this.panel3.Controls.Add(this.lblTeleBunniesFound);
            this.panel3.Location = new System.Drawing.Point(6, 220);
            this.panel3.Margin = new System.Windows.Forms.Padding(1);
            this.panel3.Name = "panel3";
            this.panel3.Size = new System.Drawing.Size(521, 142);
            this.panel3.TabIndex = 50;
            // 
            // chkDisconnectFlag
            // 
            this.chkDisconnectFlag.AutoSize = true;
            this.chkDisconnectFlag.CheckAlign = System.Drawing.ContentAlignment.MiddleRight;
            this.chkDisconnectFlag.Location = new System.Drawing.Point(422, 93);
            this.chkDisconnectFlag.Margin = new System.Windows.Forms.Padding(1);
            this.chkDisconnectFlag.Name = "chkDisconnectFlag";
            this.chkDisconnectFlag.Size = new System.Drawing.Size(80, 17);
            this.chkDisconnectFlag.TabIndex = 16;
            this.chkDisconnectFlag.Text = "Disconnect";
            this.chkDisconnectFlag.UseVisualStyleBackColor = true;
            this.chkDisconnectFlag.CheckedChanged += new System.EventHandler(this.chkDisconnectFlag_CheckedChanged);
            // 
            // txtTeleBunniesPlaced
            // 
            this.txtTeleBunniesPlaced.Location = new System.Drawing.Point(307, 89);
            this.txtTeleBunniesPlaced.Margin = new System.Windows.Forms.Padding(1);
            this.txtTeleBunniesPlaced.Name = "txtTeleBunniesPlaced";
            this.txtTeleBunniesPlaced.Size = new System.Drawing.Size(58, 20);
            this.txtTeleBunniesPlaced.TabIndex = 12;
            this.txtTeleBunniesPlaced.Validating += new System.ComponentModel.CancelEventHandler(this.textbox_Validating);
            this.txtTeleBunniesPlaced.Validated += new System.EventHandler(this.textbox_Validated);
            // 
            // chkBreakdownFlag
            // 
            this.chkBreakdownFlag.AutoSize = true;
            this.chkBreakdownFlag.CheckAlign = System.Drawing.ContentAlignment.MiddleRight;
            this.chkBreakdownFlag.Location = new System.Drawing.Point(422, 70);
            this.chkBreakdownFlag.Margin = new System.Windows.Forms.Padding(1);
            this.chkBreakdownFlag.Name = "chkBreakdownFlag";
            this.chkBreakdownFlag.Size = new System.Drawing.Size(80, 17);
            this.chkBreakdownFlag.TabIndex = 15;
            this.chkBreakdownFlag.Text = "Breakdown";
            this.chkBreakdownFlag.UseVisualStyleBackColor = true;
            this.chkBreakdownFlag.CheckedChanged += new System.EventHandler(this.chkBreakdownFlag_CheckedChanged);
            // 
            // lblTeleBunniesPlaced
            // 
            this.lblTeleBunniesPlaced.AutoSize = true;
            this.lblTeleBunniesPlaced.Location = new System.Drawing.Point(221, 93);
            this.lblTeleBunniesPlaced.Margin = new System.Windows.Forms.Padding(1, 0, 1, 0);
            this.lblTeleBunniesPlaced.Name = "lblTeleBunniesPlaced";
            this.lblTeleBunniesPlaced.Size = new System.Drawing.Size(84, 13);
            this.lblTeleBunniesPlaced.TabIndex = 51;
            this.lblTeleBunniesPlaced.Text = "Bunnies Placed:";
            // 
            // chkDefenceFlag
            // 
            this.chkDefenceFlag.AutoSize = true;
            this.chkDefenceFlag.CheckAlign = System.Drawing.ContentAlignment.MiddleRight;
            this.chkDefenceFlag.Location = new System.Drawing.Point(435, 48);
            this.chkDefenceFlag.Margin = new System.Windows.Forms.Padding(1);
            this.chkDefenceFlag.Name = "chkDefenceFlag";
            this.chkDefenceFlag.Size = new System.Drawing.Size(67, 17);
            this.chkDefenceFlag.TabIndex = 14;
            this.chkDefenceFlag.Text = "Defence";
            this.chkDefenceFlag.UseVisualStyleBackColor = true;
            this.chkDefenceFlag.CheckedChanged += new System.EventHandler(this.chkDefenceFlag_CheckedChanged);
            // 
            // txtTeleBunniesPickedUp
            // 
            this.txtTeleBunniesPickedUp.Location = new System.Drawing.Point(118, 88);
            this.txtTeleBunniesPickedUp.Margin = new System.Windows.Forms.Padding(1);
            this.txtTeleBunniesPickedUp.Name = "txtTeleBunniesPickedUp";
            this.txtTeleBunniesPickedUp.Size = new System.Drawing.Size(57, 20);
            this.txtTeleBunniesPickedUp.TabIndex = 11;
            this.txtTeleBunniesPickedUp.Validating += new System.ComponentModel.CancelEventHandler(this.textbox_Validating);
            this.txtTeleBunniesPickedUp.Validated += new System.EventHandler(this.textbox_Validated);
            // 
            // lblTeleBunniesPickedUp
            // 
            this.lblTeleBunniesPickedUp.AutoSize = true;
            this.lblTeleBunniesPickedUp.Location = new System.Drawing.Point(15, 92);
            this.lblTeleBunniesPickedUp.Margin = new System.Windows.Forms.Padding(1, 0, 1, 0);
            this.lblTeleBunniesPickedUp.Name = "lblTeleBunniesPickedUp";
            this.lblTeleBunniesPickedUp.Size = new System.Drawing.Size(101, 13);
            this.lblTeleBunniesPickedUp.TabIndex = 49;
            this.lblTeleBunniesPickedUp.Text = "Bunnies Picked Up:";
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
            // txtTeleBucketsSearched
            // 
            this.txtTeleBucketsSearched.Location = new System.Drawing.Point(307, 48);
            this.txtTeleBucketsSearched.Margin = new System.Windows.Forms.Padding(1);
            this.txtTeleBucketsSearched.Name = "txtTeleBucketsSearched";
            this.txtTeleBucketsSearched.Size = new System.Drawing.Size(58, 20);
            this.txtTeleBucketsSearched.TabIndex = 9;
            this.txtTeleBucketsSearched.Validating += new System.ComponentModel.CancelEventHandler(this.textbox_Validating);
            this.txtTeleBucketsSearched.Validated += new System.EventHandler(this.textbox_Validated);
            // 
            // lblTeleBucketsSearched
            // 
            this.lblTeleBucketsSearched.AutoSize = true;
            this.lblTeleBucketsSearched.Location = new System.Drawing.Point(208, 52);
            this.lblTeleBucketsSearched.Margin = new System.Windows.Forms.Padding(1, 0, 1, 0);
            this.lblTeleBucketsSearched.Name = "lblTeleBucketsSearched";
            this.lblTeleBucketsSearched.Size = new System.Drawing.Size(98, 13);
            this.lblTeleBucketsSearched.TabIndex = 46;
            this.lblTeleBucketsSearched.Text = "Buckets Searched:";
            // 
            // txtTeleBunniesFound
            // 
            this.txtTeleBunniesFound.Location = new System.Drawing.Point(117, 49);
            this.txtTeleBunniesFound.Margin = new System.Windows.Forms.Padding(1);
            this.txtTeleBunniesFound.Name = "txtTeleBunniesFound";
            this.txtTeleBunniesFound.Size = new System.Drawing.Size(58, 20);
            this.txtTeleBunniesFound.TabIndex = 8;
            this.txtTeleBunniesFound.Validating += new System.ComponentModel.CancelEventHandler(this.textbox_Validating);
            this.txtTeleBunniesFound.Validated += new System.EventHandler(this.textbox_Validated);
            // 
            // lblTeleBunniesFound
            // 
            this.lblTeleBunniesFound.AutoSize = true;
            this.lblTeleBunniesFound.Location = new System.Drawing.Point(34, 53);
            this.lblTeleBunniesFound.Margin = new System.Windows.Forms.Padding(1, 0, 1, 0);
            this.lblTeleBunniesFound.Name = "lblTeleBunniesFound";
            this.lblTeleBunniesFound.Size = new System.Drawing.Size(81, 13);
            this.lblTeleBunniesFound.TabIndex = 45;
            this.lblTeleBunniesFound.Text = "Bunnies Found:";
            // 
            // panel6
            // 
            this.panel6.Controls.Add(this.btnCancel);
            this.panel6.Controls.Add(this.btnSave);
            this.panel6.Location = new System.Drawing.Point(6, 363);
            this.panel6.Margin = new System.Windows.Forms.Padding(1);
            this.panel6.Name = "panel6";
            this.panel6.Size = new System.Drawing.Size(521, 44);
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
            this.btnCancel.TabIndex = 18;
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
            this.btnSave.TabIndex = 17;
            this.btnSave.Text = "Save";
            this.btnSave.UseVisualStyleBackColor = true;
            this.btnSave.Click += new System.EventHandler(this.btnSave_Click);
            // 
            // panel7
            // 
            this.panel7.Controls.Add(this.statusStrip1);
            this.panel7.Location = new System.Drawing.Point(6, 495);
            this.panel7.Margin = new System.Windows.Forms.Padding(1);
            this.panel7.Name = "panel7";
            this.panel7.Size = new System.Drawing.Size(521, 22);
            this.panel7.TabIndex = 54;
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
            this.statusStrip1.TabIndex = 51;
            this.statusStrip1.Text = "statusStrip1";
            // 
            // toolStripStatusLabel1
            // 
            this.toolStripStatusLabel1.Name = "toolStripStatusLabel1";
            this.toolStripStatusLabel1.Size = new System.Drawing.Size(0, 0);
            // 
            // TeamMatchActionEntryForm_BunnyBots2017
            // 
            this.AcceptButton = this.btnSave;
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoSize = true;
            this.CancelButton = this.btnCancel;
            this.CausesValidation = false;
            this.ClientSize = new System.Drawing.Size(532, 428);
            this.Controls.Add(this.panel7);
            this.Controls.Add(this.panel6);
            this.Controls.Add(this.panel3);
            this.Controls.Add(this.panel2);
            this.Controls.Add(this.panel1);
            this.Controls.Add(this.lblAddAMatch);
            this.Controls.Add(this.txtScouter);
            this.Controls.Add(this.lblScouter);
            this.Margin = new System.Windows.Forms.Padding(1);
            this.Name = "TeamMatchActionEntryForm_BunnyBots2017";
            this.Padding = new System.Windows.Forms.Padding(4);
            this.Text = "Team Match Action Entry";
            ((System.ComponentModel.ISupportInitialize)(this.errorProvider1)).EndInit();
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            this.panel2.ResumeLayout(false);
            this.panel2.PerformLayout();
            this.panel3.ResumeLayout(false);
            this.panel3.PerformLayout();
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
		private System.Windows.Forms.CheckBox chkBreakdownFlag;
		private System.Windows.Forms.CheckBox chkDefenceFlag;
		private System.Windows.Forms.Panel panel3;
		private System.Windows.Forms.TextBox txtTeleBunniesPickedUp;
		private System.Windows.Forms.Label lblTeleBunniesPickedUp;
		private System.Windows.Forms.Label label11;
		private System.Windows.Forms.TextBox txtTeleBucketsSearched;
		private System.Windows.Forms.Label lblTeleBucketsSearched;
		private System.Windows.Forms.TextBox txtTeleBunniesFound;
		private System.Windows.Forms.Label lblTeleBunniesFound;
		private System.Windows.Forms.Panel panel2;
		private System.Windows.Forms.Label lblBlueAlliance;
		private System.Windows.Forms.TextBox txtAutoFarBucketLift;
		private System.Windows.Forms.Label lblAutoFarBucketLift;
		private System.Windows.Forms.Panel panel7;
        private System.Windows.Forms.TextBox txtAutoMidlineCross;
        private System.Windows.Forms.Label lblAutoMidlineCross;
        private System.Windows.Forms.TextBox txtAutoNearBucketLift;
        private System.Windows.Forms.Label lblAutoNearBucketLift;
        private System.Windows.Forms.TextBox txtTeleBunniesPlaced;
        private System.Windows.Forms.Label lblTeleBunniesPlaced;
        private System.Windows.Forms.CheckBox chkDisconnectFlag;
        private System.Windows.Forms.StatusStrip statusStrip1;
        private System.Windows.Forms.ToolStripStatusLabel toolStripStatusLabel1;
    }
}