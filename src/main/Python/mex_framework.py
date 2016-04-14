import requests
import json

base_url = 'http://localhost:8080/MexRestServer/resources/setexperiment/'
author_name = "Igu Costa"

def set_author_name(author):
    payload = {"Author": author}
    request = requests.post(base_url + "setauthorname", data=json.dumps(payload))

set_author_name(author_name)