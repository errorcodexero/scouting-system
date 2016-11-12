from django.shortcuts import render
from django.views.generic import TemplateView
from django.http import HttpResponse
from django.template import loader

# Create your views here.


def test_view(request):
    c = {'TEST': 'a'}
    t = loader.get_template("explore/index.html")
    return HttpResponse(t.render(c, request), content_type='text/html')
    #return render("explore/index.html", context, context_instalnce=RequestContext(request))
