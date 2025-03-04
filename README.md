Arquitectura Limpia - Ejemplo de estructura 
Para proyecto Grande mejor hacerlo por Features
* Es un Ejemplo para saber que puede contener cada carpeta

movies/
├── ui/                    
│   ├── MovieListScreen.kt   # Pantalla de lista de películas
│   ├── MovieUIState.kt      # Estado de la UI para películas
│   ├── Navegación
│   ├── Inyección (DI)
│   
├── application(data)/           
│   ├── MovieViewModel.kt    # ViewModel para la lógica de la aplicación
│   ├── database/       # Implementación de la base de datos (ej: Room, SQLite)
│   ├── api/            # Llamadas a APIs externas (ej: Retrofit, Ktor)
│   ├── repositories/   # Implementaciones de repositorios (ej: MovieRepositoryImpl)
│   └── mappers/        # Mappers para convertir entre entidades de dominio y de data
│   └── Viewmodels/     
│   
├── domain/                
│   ├── Movie.kt             # Entidad de negocio (película)
│   ├── MovieRepository.kt   # Interfaz del repositorio
│   ├── AddMovieUseCase.kt   # Caso de uso para agregar películas
│   ├── GetAllMoviesUseCase.kt # Caso de uso para obtener películas
│   │
│   ├── entities/       # Entidades de negocio (ej: Movie)
│   ├── repositories/   # Interfaces de repositorios (ej: MovieRepository)
│   ├── usecases/       # Casos de uso (ej: AddMovieUseCase, GetAllMoviesUseCase)
│   └── exceptions/     # Excepciones específicas del dominio (opcional)
