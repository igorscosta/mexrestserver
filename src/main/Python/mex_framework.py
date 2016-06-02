# -*- coding: UTF-8 -*-


import requests
import json

def experiment_info(set_experiment_info):
    def get_experiment_info(*args, **kwargs):
        params = set_experiment_info()
        json_params = json.dumps(params, indent=2)
        print json_params
        requests.post('http://localhost:8080/MexRestServer/resources/experiment/setexperimentinfo',json = params)
        return set_experiment_info(*args, **kwargs)
    return get_experiment_info

def hardware(set_hardware_info):
    def get_hardware_info(*args, **kwargs):
        params = set_hardware_info()
        json_params = json.dumps(params, indent=2)
        print json_params
        requests.post('http://localhost:8080/MexRestServer/resources/experiment/sethardware',json = params)
        return set_hardware_info(*args, **kwargs)
    return get_hardware_info()