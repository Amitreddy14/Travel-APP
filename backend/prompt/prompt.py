import json
from enum import Enum


class Role(Enum):
    SYSTEM = "system"
    ASSISTANT = "assistant"
    USER = "user"


def _create_message(role: Role, content):
    return {"role": role.value, "content": content}
