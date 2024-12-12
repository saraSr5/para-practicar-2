package com.es.examen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.util.Vector;

public class MatriculaTest {

    private Matricula matricula;

    @BeforeEach
    public void setUp() {
        // Mock de objetos
        matricula = mock(Matricula.class);
    }

    // Cree una prueba de unidad para la clase Matricula que verifique que se lanza
    // una excepción cuando el vector de asignaturas es nulo.
    @Test
    void excepcionSiVectorAsignaturasEsNulo() {
        matricula = new Matricula(null);
        Exception excepcion = assertThrows(
                Exception.class,
                matricula::getImporte, // Llamar al método que esperamos falle
                "Se esperaba que el método getImporte lanzara una excepción");
        assertTrue(excepcion instanceof Exception);
    }

    // Cree una prueba de unidad para la clase Matricula que verifique que se
    // calcula correctamente el importe de la matricula.
    @Test
    public void correctoImporteMatricula() throws Exception {

        Vector<Asignatura> asignaturas = new Vector<>();

        Asignatura asignatura1 = mock(Asignatura.class);
        Asignatura asignatura2 = mock(Asignatura.class);

        when(asignatura1.getImporte()).thenReturn(100.0);
        when(asignatura2.getImporte()).thenReturn(150.0);

        asignaturas.add(asignatura1);
        asignaturas.add(asignatura2);

        matricula = new Matricula(asignaturas);

        // Act: Calcula el importe total
        double importeTotal = matricula.getImporte();

        // Assert: Verifica que el importe es el esperado
        assertEquals(250.0, importeTotal, "El importe calculado es correcto.");
    }

    // Cree una prueba de unidad para la clase Matricula que verifique que el método
    // getImporte() de la clase Matricula
    // recorretodas las asignaturas de vectorAsignaturas
    @Test
    public void recorreTodasAsignaturas() throws Exception {

        Vector<Asignatura> asignaturas = new Vector<>();

        Asignatura asignatura1 = mock(Asignatura.class);
        Asignatura asignatura2 = mock(Asignatura.class);

        when(asignatura1.getImporte()).thenReturn(100.0);
        when(asignatura2.getImporte()).thenReturn(150.0);

        asignaturas.add(asignatura1);
        asignaturas.add(asignatura2);

        matricula = new Matricula(asignaturas);

        double importeTotal = matricula.getImporte();

        verify(asignatura1, times(1)).getImporte();
        verify(asignatura2, times(1)).getImporte();

        assertEquals(250.0, importeTotal, "El importe calculado es correcto.");
    }

}
