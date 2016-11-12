from django.shortcuts import render

# Create your views here.

class IndexPageView(TemplateView):
    def get_contex_data(self, request=None, **kwargs)
