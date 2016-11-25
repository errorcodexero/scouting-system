from django.shortcuts import render
from django.http import HttpResponse
from django.views.generic.base import View
from django.template import loader
from django.views.decorators.http import require_http_methods
from django.views.decorators.csrf import csrf_exempt
from django.utils.decorators import method_decorator
from django.core import serializers
import matplotlib.pyplot as plt

import scipy.stats as stats

import math
import json

import numpy as np
from FRC_Statistics.FRC_Statistics import *

# Create your views here.

results_matrix = np.array([61, 39, 62, 100, 86, 60, 74, 51, 66, 44, 52, 32, 65, 31, 45, 62, 72,
79, 41, 82, 36, 74, 75, 58, 27, 64, 77, 55, 70, 49, 30, 84, 97, 96, 11, 117, 51, 24, 23, 34,
82, 41, 101, 13, 59, 55, 89, 125, 37, 67, 114, 27, 61, 56, 59, 44, 76, 42, 56, 51, 70, 8, 38,
126, 64, 68, 93, 38, 36, 89, 87, 53, 59, 46, 47, 62, 52, 64, 85, 104, 64, 43, 48, 57, 27, 84,
54, 67, 61, 62, 53, 56, 108, 57, 81, 61, 61, 78, 54, 74, 63, 53, 62, 33, 35, 94, 62, 99, 55,
31, 59, 43, 84, 77, 55, 59, 45, 46, 57, 60, 53, 38, 11, 60, 78, 79, 85, 65, 51, 60, 75, 57, 51,
64, 33, 60, 46, 98, 104, 65, 81, 38, 53, 65])

team_matrix = np.genfromtxt(fname='assets/team_data.data', delimiter=',')

def normpdf(x, mean, sd):
    var = float(sd)**2
    pi = 3.1415926
    denom = (2*pi*var)**.5
    num = math.exp(-(float(x)-float(mean))**2/(2*var))
    return num/denom

class ExplorerView(View):

    team_list = []
    team_name_dict = {}
    opr = get_opr(team_matrix, results_matrix)
    dpr = get_dpr(team_matrix, results_matrix)

    stddev = np.array([8.4])

    plot_spacing = np.linspace(stats.norm.ppf(0.01), stats.norm.ppf(0.99), 100)

    opr_norm = stats.norm(loc=np.average(opr[0]), scale=stddev)

    opr_team_dict = {}

    opr_pdf_data = []

    temp_list = range(0, 40)

    for i in range(0, 40):
        #multiply by 100 to be easier to graph
        opr_pdf_data.append((opr_norm.pdf(i)[0] * 100))
    @method_decorator(csrf_exempt)
    def dispatch(self, request, *args, **kwargs):
        return super(ExplorerView, self).dispatch(request, *args, **kwargs)

    def get(self, request, *args, **kwargs):
        if request.method == 'GET':
            if len(self.team_list) == 0:
                for i in range(1, int(len(results_matrix)/2) + 1):

                    self.team_list.append("Team " + str(i))
                    self.team_name_dict["Team " + str(i)] = (i - 1)

                for i in range(0, int(len(results_matrix)/2)):
                    self.opr_team_dict[self.opr[0][i]] = "Team " + str(i + 1)

            temp_opr = []
            for i in range(0, len(self.opr_pdf_data)):
                temp_opr.append(self.opr_pdf_data[i])

            sorted_opr = np.sort(self.opr[0])
            formatted_sorted_opr = []
            for i in range(0, len(sorted_opr)):
                formatted_sorted_opr.append(sorted_opr[i])

            t = loader.get_template('explore/index.html')
            context = {'OPR': self.opr[0][0], 'DPR': self.dpr[0][0][0],
            'team_list': self.team_list, 'current_team': self.team_list[0],
            'team_dictionary' : self.team_name_dict, 'opr_x': self.temp_list,
            'opr_y': temp_opr, 'opr_team_dict': self.opr_team_dict,
            'sorted_opr': formatted_sorted_opr}

            return HttpResponse(t.render(context, request), content_type='text/html')

    def post(self, request, *args, **kwargs):
        print("TEST")
        if request.method == 'POST':
            if 'team_name' in request.POST:

                team_number = self.team_name_dict.get(request.POST['team_name'])

                response_data = """
                {
                    \"data\": [%0.4f, %0.4f],
                    \"team\": \"%s\"
                }"""%(self.opr[0][team_number], self.dpr[0][team_number], request.POST['team_name'])
                return HttpResponse(json.dumps(response_data), content_type="application/json")
