import requests
import json
from datetime import date

base_url = 'http://localhost:8080/MexRestServer/resources/experiment/'
id = '1'
title = 'Python Test Experiment'
description = 'test'
email = 'costa@ime.eb.br'
author_name = "Igor Costa"
date = date.today()
context = 'test'


def set_experiment_info():
    payload = {
        "id": id,
        "title": title,
        "description": description,
        "email": email,
        "author": author_name,
        #"date": date,
        "context": context
    }
    request = requests.post(base_url + "setexperimentinfo", data=json.dumps(payload))

set_experiment_info()