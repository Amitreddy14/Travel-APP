import os
import instructor
from openai import OpenAI

from prompt.models import Itinerary
from prompt.prompt import get_itinerary_prompt
from dotenv import load_dotenv

MODEL_3_5 = "gpt-3.5-turbo-0125"
MODEL_4 = "gpt-4-0125-preview"

MODEL = MODEL_3_5

# Flag to turn on debugging prints for GPT input and output
debug = True

# load in API key from .env
load_dotenv()

openai_key = os.environ.get("OPENAI_KEY")
oai_client = OpenAI(api_key=openai_key)

# Enables `response_model`
client = instructor.patch(oai_client, mode=instructor.Mode.JSON)


def get_client():
    return client