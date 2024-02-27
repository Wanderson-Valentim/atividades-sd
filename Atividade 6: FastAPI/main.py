from typing import Union
from fastapi import FastAPI
from datetime import datetime
import platform

app = FastAPI()

@app.get("/")
def read_root():
  return {"Hello": "World"}

@app.get("/data-hora")
def get_current_datetime():
  return {"data_hora": datetime.now().isoformat()}

@app.get("/somar/{num1}/{num2}")
def somar_numeros(num1: int, num2: int):
  resultado = num1 + num2
  return {"resultado": resultado}
  
@app.get("/multiplicar/{num1}/{num2}")
def somar_numeros(num1: int, num2: int):
  resultado = num1 * num2
  return {"resultado": resultado}

@app.get("/info-servidor")
def get_system_info():
  system_info = {
      "sistema_operacional": platform.system(),
      "versao_sistema": platform.version(),
  }
  return system_info