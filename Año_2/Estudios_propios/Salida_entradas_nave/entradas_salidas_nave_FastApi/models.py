from sqlalchemy import Column, Integer, String, Enum
from database import Base
import enum

# Enum para rol.
class RolEnum(str, enum.Enum):
    user = "user"
    admin = "admin"

class Salida(Base):
    __tablename__ = "salidas"

    id = Column(Integer, primary_key=True, index=True)
    nombre = Column(String(100), nullable=False)
    ubicacion = Column(String(255), nullable=False)
    visibilidad = Column(String(50), nullable=False)
    descripcion = Column(String(500), nullable=False)
    imagen1 = Column(String(255), nullable=True)
    imagen2 = Column(String(255), nullable=True)

class Usuario(Base):
    __tablename__ = "usuarios"

    id = Column(Integer, primary_key=True, index=True)
    nombre = Column(String(100), nullable=False)
    email = Column(String(100), unique=True, index=True, nullable=False)
    password = Column(String(255), nullable=False)
    rol = Column(Enum(RolEnum), nullable=False)
