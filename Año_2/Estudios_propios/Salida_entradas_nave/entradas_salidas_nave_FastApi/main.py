from fastapi import FastAPI, Body, Depends, HTTPException
from fastapi.middleware.cors import CORSMiddleware
from sqlalchemy.orm import Session
from database import SessionLocal, engine, Base
import models

# Crear tablas
Base.metadata.create_all(bind=engine)

app = FastAPI()

# CORS.
app.add_middleware(
    CORSMiddleware,
    allow_origins=["*"],
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)

# Dependencia de DB.
def get_db():
    db = SessionLocal()
    try:
        yield db
    finally:
        db.close()

# Función para salidas predeterminadas.
def crear_salidas_predeterminadas(db: Session):
    if db.query(models.Salida).count() == 0:
        salidas_iniciales = [
            {
                "nombre": "Salida principal",
                "ubicacion": "Parte delantera de la nave, cerca de la peluquería.",
                "visibilidad": "Buena",
                "descripcion": "Es grande y fácil de ver, pueden entrar varias personas simultáneamente. Tiene rampa de acceso para discapacitados.",
                "imagen1": "Salida-1-945x424.jpg",
                "imagen2": "Salida-1-945x424.jpg"
            },
            {
                "nombre": "Salida de emergencia",
                "ubicacion": "Parte lateral de la nave, junto al taller 2000. Si miras cara a los ordenadores, a la derecha.",
                "visibilidad": "Buena",
                "descripcion": "Tamaño normal y fácil de ver gracias al cartel verde. Pueden entrar 1-2 personas simultáneamente. Tiene rampa de acceso para discapacitados.",
                "imagen1": "Salida-2-945x424.jpg",
                "imagen2": "Salida-2-945x424.jpg"
            }
        ]

        for s in salidas_iniciales:
            nueva_salida = models.Salida(**s)
            db.add(nueva_salida)
        db.commit()

# Función para usuarios predeterminados.
def crear_usuarios_predeterminadas(db: Session):
    if db.query(models.Usuario).count() == 0:
        usuarios_iniciales = [
            {
                "nombre": "admin",
                "email": "admin@gmail.com",
                "password": "12345",
                "rol": "admin"
            },
            {
                "nombre": "user",
                "email": "user@gmail.com",
                "password": "12345",
                "rol": "user"
            }
        ]

        for u in usuarios_iniciales:
            nuevo_usuario = models.Usuario(**u)
            db.add(nuevo_usuario)
        db.commit()

# Evento startup.
@app.on_event("startup")
def inicializar_datos():
    db = SessionLocal()
    try:
        crear_salidas_predeterminadas(db)
        crear_usuarios_predeterminadas(db)
    finally:
        db.close()

# ENDPOINTS SALIDAS

@app.get("/salidas", tags=["Salidas"])
def get_salidas(db: Session = Depends(get_db)):
    return db.query(models.Salida).all()

@app.get("/salidas/{id}", tags=["Salidas"])
def get_salida(id: int, db: Session = Depends(get_db)):
    salida = db.query(models.Salida).filter(models.Salida.id == id).first()
    if not salida:
        raise HTTPException(status_code=404, detail="Salida no encontrada")
    return salida

@app.post("/salidas", tags=["Salidas"])
def create_salida(
    nombre: str = Body(), ubicacion: str = Body(), visibilidad: str = Body(),
    descripcion: str = Body(), imagen1: str = Body(), imagen2: str = Body(),
    db: Session = Depends(get_db)
):
    nueva_salida = models.Salida(
        nombre=nombre, ubicacion=ubicacion, visibilidad=visibilidad,
        descripcion=descripcion, imagen1=imagen1, imagen2=imagen2
    )
    db.add(nueva_salida)
    db.commit()
    db.refresh(nueva_salida)
    return nueva_salida

@app.put("/salidas/{id}", tags=["Salidas"])
def update_salida(
    id: int, nombre: str = Body(), ubicacion: str = Body(), visibilidad: str = Body(),
    descripcion: str = Body(), imagen1: str = Body(), imagen2: str = Body(),
    db: Session = Depends(get_db)
):
    salida = db.query(models.Salida).filter(models.Salida.id == id).first()
    if not salida:
        raise HTTPException(status_code=404, detail="Salida no encontrada")
    salida.nombre = nombre
    salida.ubicacion = ubicacion
    salida.visibilidad = visibilidad
    salida.descripcion = descripcion
    salida.imagen1 = imagen1
    salida.imagen2 = imagen2
    db.commit()
    db.refresh(salida)
    return salida

@app.delete("/salidas/{id}", tags=["Salidas"])
def delete_salida(id: int, db: Session = Depends(get_db)):
    salida = db.query(models.Salida).filter(models.Salida.id == id).first()
    if not salida:
        raise HTTPException(status_code=404, detail="Salida no encontrada")
    db.delete(salida)
    db.commit()
    return {"detail": "Salida eliminada"}

# ENDPOINTS USUARIOS

@app.get("/usuarios", tags=["Usuarios"])
def get_usuarios(db: Session = Depends(get_db)):
    return db.query(models.Usuario).all()

@app.get("/usuarios/{id}", tags=["Usuarios"])
def get_usuario(id: int, db: Session = Depends(get_db)):
    usuario = db.query(models.Usuario).filter(models.Usuario.id == id).first()
    if not usuario:
        raise HTTPException(status_code=404, detail="Usuario no encontrado")
    return usuario

@app.post("/usuarios", tags=["Usuarios"])
def create_usuario(
    nombre: str = Body(), email: str = Body(), password: str = Body(),
    rol: str = Body(), db: Session = Depends(get_db)
):
    if rol not in ["user", "admin"]:
        raise HTTPException(status_code=400, detail="Rol inválido, solo 'user' o 'admin'")
    # Verificar email único.
    if db.query(models.Usuario).filter(models.Usuario.email == email).first():
        raise HTTPException(status_code=400, detail="Email ya registrado")
    nuevo_usuario = models.Usuario(
        nombre=nombre, email=email, password=password, rol=rol
    )
    db.add(nuevo_usuario)
    db.commit()
    db.refresh(nuevo_usuario)
    return nuevo_usuario

@app.put("/usuarios/{id}", tags=["Usuarios"])
def update_usuario(
    id: int, nombre: str = Body(), email: str = Body(), password: str = Body(),
    rol: str = Body(), db: Session = Depends(get_db)
):
    usuario = db.query(models.Usuario).filter(models.Usuario.id == id).first()
    if not usuario:
        raise HTTPException(status_code=404, detail="Usuario no encontrado")
    if rol not in ["user", "admin"]:
        raise HTTPException(status_code=400, detail="Rol inválido, solo 'user' o 'admin'")
    usuario.nombre = nombre
    usuario.email = email
    usuario.password = password
    usuario.rol = rol
    db.commit()
    db.refresh(usuario)
    return usuario

@app.delete("/usuarios/{id}", tags=["Usuarios"])
def delete_usuario(id: int, db: Session = Depends(get_db)):
    usuario = db.query(models.Usuario).filter(models.Usuario.id == id).first()
    if not usuario:
        raise HTTPException(status_code=404, detail="Usuario no encontrado")
    db.delete(usuario)
    db.commit()
    return {"detail": "Usuario eliminado"}
