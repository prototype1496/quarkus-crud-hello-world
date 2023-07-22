package org.alinuswe.configuration;

/**
 * The type Routes. All routes for various controllers will come here
 */
public final class Routes {

    private Routes() {
    }

    /**
     * Routes for the Fetch transactions controller.
     */
    public static final class PersonDetails {
        private PersonDetails() {
        }

        public static final String GET_PERSON_DETAILS = "/get";


        public static final String CREATE_PERSON_DETAILS= "/create";


        public static final String DELETE_PERSON_DETAILS= "/{id}/delete";
    }



}
