package film;

public class MVC_Film {
    ViewFilm viewFilm = new ViewFilm();
    ModelFilm modelFilm = new ModelFilm();
    ControllerFilm controllerFilm = new ControllerFilm(viewFilm, modelFilm);
}
