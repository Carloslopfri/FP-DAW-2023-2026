from fastapi import FastAPI, Body
from fastapi.responses import HTMLResponse

app = FastAPI()

# Lista de peliculas.
movies = [
    {
        "id": 1,
        "title": "Avatar",
        "overview": "En un planeta llamado pandora",
        "year": "2009",
        "rating": 7.8,
        "category": "accion"
    },
    {
        "id": 2,
        "title": "Avenges",
        "overview": "En un planeta llamado pandora",
        "year": "2009",
        "rating": 7.8,
        "category": "comedia"
    }
]

# Hacemos un get que devuelva un string.
@app.get('/', tags=['Home'])
def home():
    return "Hola mundo."

# Hacemos un get que devulva la lista completa de movies.
@app.get('/movies', tags=['Movies'])
def get_movies():
    return movies

# Hacemos un get que devuelva una movie concreta de la lista de movies.
@app.get('/movies/{id}', tags=['Movies'])
def get_movie(id: int):
    for movie in movies:
        if movie['id'] == id:
            return movie
    return []

# Filtramos las movies por atributo, en este caso category.
@app.get('/movies/', tags=['Movies'])
def get_movie_by_category(category: str):
    for movie in movies:
        if movie['category'] == category:
            return movie
    return []

# Creamos la función para añadir una movie.
@app.post('/movies', tags=['Movies'])
def create_movie(id: int = Body(), title: str = Body(), overview: str = Body(), year: int = Body(), rating: float = Body(), category: str = Body()):
    movies.append({
        'id': id,
        'title': title,
        'overview': overview,
        'year': year,
        'rating': rating,
        'category': category
    })
    return movies

# Creamos la función para modificar una movie en concreto.
@app.put('/movies/{id}', tags=['Movies'])
def update_movie(id: int, title: str = Body(), overview: str = Body(), year: int = Body(), rating: float = Body(), category: str = Body()):
    for movie in movies:
        if movie['id'] == id:
            movie['title'] = title
            movie['overview'] = overview
            movie['year'] = year
            movie['rating'] = rating
            movie['category'] = category
    return movies

# Creamos la función para eliminar una movie.
@app.delete('/movies/{id}', tags=['Movies'])
def delete_movie(id: int):
    for movie in movies:
        if movie['id'] == id:
            movies.remove(movie)
    return movies