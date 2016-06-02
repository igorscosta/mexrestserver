from sklearn import tree
from sklearn.datasets import load_iris
from sklearn.cross_validation import cross_val_score
import mex_framework



iris = load_iris()
clf = tree.DecisionTreeClassifier()
clf = clf.fit(iris.data, iris.target)

@mex_framework.experiment_info
def set_experiment_info():
    created_by = "Igor Costa 2"
    email="igorcosta@ime.eb.br"
    title="Scikit Learn Test"
    tags=['Scikit Learn', 'Python 2.7', 'MEX', 'Iris']

    params = {
        'author': created_by,
        'email': email,
        'title': title,
        'tags': tags
    }

    return params

@mex_framework.hardware
def set_hardware_info():
    cpu="Intel Core i7"
    memory="8 GB"
    hdType="SSD"
    cache = '6M'
    os = 'OSX El Capitan 10.11.5'
    video = 'Nvidia GForce 630M'


    params = {
        'cpu': cpu,
        'memory': memory,
        'hd': hdType,
        'cache': cache,
        'os': os,
        'video': video
    }

    return params

def start():
    feature_names = iris.feature_names
    class_names = iris.target_names

    #print feature_names, class_names

def make_prediction():
    predicition = clf.predict(iris.data[:1, :])
    #print predicition


set_experiment_info()
set_hardware_info()