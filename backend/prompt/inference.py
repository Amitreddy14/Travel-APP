import os
import instructor
from openai import OpenAI

from prompt.models import Itinerary
from prompt.prompt import get_itinerary_prompt
from dotenv import load_dotenv

MODEL_3_5 = "gpt-3.5-turbo-0125"
MODEL_4 = "gpt-4-0125-preview"

MODEL = MODEL_3_5
