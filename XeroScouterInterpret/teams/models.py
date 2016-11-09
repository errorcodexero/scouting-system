from django.db import models

# Create your models here.

class team(models.Model):
    team_id = models.IntegerField(primary_key=True)
    tba_team_key = models.CharField(max_length=45, blank=True)
    long_name = models.CharField(max_length=255, blank=True)
    name = models.CharField(max_length=255, blank=True)
    logo_file_location = models.CharField(max_length=2000, blank=True)
    city = models.CharField(max_length=255, blank=True)
    state_code = models.CharField(max_length=45, blank=True)
    country = models.CharField(max_length=255, blank=True)
    motto = models.CharField(max_length=2000, blank=True)
    rookie_year = models.IntegerField(blank=True)
    robot_name = models.CharField(max_length=255, blank=True)
    robot_picture_file_location = models.CharField(max_length=2000, blank=True)
    robot_drive_type = models.CharField(max_length=45, blank=True)
    robot_wheel_count = models.IntegerField(blank=True)
    robot_drive_motor_count = models.IntegerField(blank=True)
    robot_description = models.CharField(max_length=2000, blank=True)
    pit_scout_comments = models.CharField(max_length=2000, blank=True)

class match(models.Model):
    match_id = models.IntegerField(primary_key=True)
    event_id = models.ForeignKey(event, on_delete=models.CASCADE)
    tba_match_key = models.CharField(max_length=255, blank=True)
    comp_level = models.CharField(max_length=45, blank=True)
    set_number = models.CharField(max_length=45, blank=True)
    match_number = models.CharField(max_length=45, blank=True)
    status = models.CharField(max_length=45, blank=True)
    red_auto_score = models.IntegerField(blank=True)
    red_teleop_score = models.IntegerField(blank=True)
    red_total_score = models.IntegerField(blank=True)
    red_qp = models.IntegerField(blank=True)
    red_foul_points = models.IntegerField(blank=True)
    blue_auto_score = models.IntegerField(blank=True)
    blue_teleop_score = models.IntegerField(blank=True)
    blue_total_score = models.IntegerField(blank=True)
    blue_qp = models.IntegerField(blank=True)
    blue_foul_points = models.IntegerField(blank=True)
    winner = models.CharField(max_length=45, blank=True)
    drive_team_comments = models.CharField(max_length=2000, blank=True)

class event(models.Model):
    event_id = models.IntegerField(primary_key=True)
    tba_event_key = models.CharField(max_length=45, blank=True)
    name = models.CharField(max_length=255, blank=True)
    short_name = models.CharField(max_length=255, blank=True)
    event_type = models.CharField(max_length=255, blank=True)
    event_district = models.CharField(max_length=255, blank=True)
    year = models.IntegerField()
    week = models.IntegerField()
    location = models.CharField(max_length=255, blank=True)
    tba_event_code = models.CharField(max_length=45, blank=True)


class team_match(models.Model):
    team_match_id = models.IntegerField(primary_key=True)
    team_id = models.ForeignKey(team, on_delete=models.CASCADE)
    match_id = models.ForeignKey(match, on_delete=models.CASCADE)
    alliance = models.CharField(max_length=45, blank=True)
    position = models.IntegerField(blank=True)

class action_type(models.Model):
    action_type_id = models.IntegerField(primary_key=True)
    name = models.CharField(max_length=255, default="No name")
    description = models.CharField(max_length=2000, default="No description")
    match_phase = models.CharField(max_length=45, blank=True)
    points = IntegerField(default=0, blank=True)
    opponent_points = IntegerField(default=0, blank=True)
    qual_points = IntegerField(default=0, blank=True)
    foul_points = IntegerField(default=0, blank=True)
    coop_flag = models.CharField(max_length=1, blank=True)
    catagory = models.CharField(max_length=255, default="Uncatagorized")
class team_match_action(models.Model):
    team_match_action_id = models.IntegerField(primary_key=True)
    team_match_id = models.ForeignKey(team_match_id)
    action_type_id = models.ForeignKey(action_type_id)
    quantity = models.IntegerField(default=1)
    start_time = models.DateTimeField(blank=True)
    end_time = models.DateTimeField(blank=True)
    object_count = models.IntegerField(blank=True)

class data_view_bunny_bots(models.Model):
    team_match_id = team_match.team_match_id()
    team_match_action_id = team_match_action.team_match_action_id()
    team_match_action_id = team_match_action.quantity()
