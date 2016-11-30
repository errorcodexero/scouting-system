from django.shortcuts import render
from django.http import HttpResponse
from django.views.generic.base import View
from django.template import loader
from django.views.decorators.http import require_http_methods
from django.views.decorators.csrf import csrf_exempt
from django.utils.decorators import method_decorator
from django.core import serializers

class HomeView(View):

    @method_decorator(csrf_exempt)
    def dispatch(self, request, *args, **kwargs):
        return super(HomeView, self).dispatch(request, *args, **kwargs)

    def get(self, request, *args, **kwargs):
        if request.method == 'GET':
            t = loader.get_template('home/index.html')
            context = {}

            return HttpResponse(t.render(context, request), content_type='text/html')
