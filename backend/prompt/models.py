from typing import List
from pydantic import BaseModel


# A Pydantic model for the itinerary of a day
class DaySchedule(BaseModel):
    day: int
    heading: str
    paragraph: str
    remaining_budget: float