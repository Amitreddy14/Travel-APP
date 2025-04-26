from flask import Flask, Response, request
from flask_cors import CORS, cross_origin

from prompt.inference import get_itinerary, get_itinerary_freeform

app = Flask(__name__)
cors = CORS(app)
app.config["CORS_HEADERS"] = "Content-Type"


@cross_origin()
@app.route("/status", methods=["GET"])
def status():
    return Response(status=200)


@cross_origin()
@app.route("/generate-itinerary", methods=["POST"])