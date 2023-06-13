package unal.todosalau.powerplay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

private ListView resourceListView;
private EditText editTextName;
private Button buttonPerform;
private Button addResourceButton;
private Button searchResourceButton;
private Button deleteResourceButton;

private ArrayList<String> resourceList;
private ArrayList<String> searchResults;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Inicializar las vistas
    resourceListView = findViewById(R.id.resourceListView);
    editTextName = findViewById(R.id.editTextTextPersonName);
    buttonPerform = findViewById(R.id.buttonRealizar);
    addResourceButton = findViewById(R.id.addResourceButton);
    searchResourceButton = findViewById(R.id.searchResourceButton);
    deleteResourceButton = findViewById(R.id.deleteResourceButton);

    resourceList = new ArrayList<>();
    searchResults = new ArrayList<>();

    // Crear un adaptador personalizado o usar uno predefinido, por ejemplo ArrayAdapter
    ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, resourceList);

    Toast.makeText(getApplicationContext(), "Preparandot todo.!", Toast.LENGTH_SHORT).show();

    // Configurar el botón de agregar recurso
    addResourceButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //Cargar el layout vertical a mostrar
            LinearLayout linearLayout = findViewById(R.id.opciones);
            //Cargar el textview que se cambiar el titulo
            TextView textViewOptions = findViewById(R.id.textView3);
            //Cargar el editText que se quiere cambiar el hint
            EditText editTextOptions = findViewById(R.id.editTextTextPersonName);
            //Cargar el Button que se quiere cambiar el text
            Button botonAgregar = findViewById(R.id.buttonRealizar);

            //Cambiar el nombre del titulo a "Agregar Recurso"
            textViewOptions.setText("Agregar Recurso");
            //Cambiar el hint del editText
            editTextOptions.setHint("Nombre, del recurso");
            //Cambiar el texto del boton
            botonAgregar.setText("Agregar");
            editTextOptions.setText("");
            editTextOptions.setEnabled(true);
            Toast.makeText(getApplicationContext(), "Agrega nuevos recursos.!",
                    Toast.LENGTH_SHORT).show();

            if (linearLayout.getVisibility() == View.GONE) {
                linearLayout.setVisibility(View.VISIBLE); // Muestra el LinearLayout
                ArrayAdapter<String> agregarAdapter = new ArrayAdapter<>(MainActivity.this,
                        android.R.layout.simple_list_item_1, resourceList);
                resourceListView.setAdapter(agregarAdapter);

                botonAgregar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String resourceName = editTextOptions.getText().toString();
                        resourceList.add(resourceName);
                        adapter.notifyDataSetChanged();
                        editTextName.setText("");
                        //Pasar el adaptador a la resourceListView
                        ArrayAdapter<String> agregarAdapter = new ArrayAdapter<>(MainActivity.this,
                                android.R.layout.simple_list_item_1, resourceList);
                        resourceListView.setAdapter(agregarAdapter);
                        // Oculta el LinearLayout
                        linearLayout.setVisibility(View.GONE); // Oculta el LinearLayout
                        Toast.makeText(getApplicationContext(), "Recurso agregado.!",
                                Toast.LENGTH_SHORT).show();
                    }
                });
            } else {
                // Oculta el LinearLayout
                linearLayout.setVisibility(View.GONE); // Oculta el LinearLayout
            }

            // Resto de acciones a realizar cuando se agrega un recurso
        }
    });

    // Configurar el botón de buscar recurso
    searchResourceButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            // Acciones a realizar cuando se hace clic en el botón
            //Cargar el layout vertical a mostrar
            LinearLayout linearLayout = findViewById(R.id.opciones);
            //Cargar el textview que se cambiar el titulo
            TextView textViewOptions = findViewById(R.id.textView3);
            //Cargar el editText que se quiere cambiar el hint
            EditText editTextOptions = findViewById(R.id.editTextTextPersonName);
            //Cargar el Button que se quiere cambiar el text
            Button botonBuscar = findViewById(R.id.buttonRealizar);

            //Cambiar el nombre del titulo a "Agregar Recurso"
            textViewOptions.setText("Buscar Recurso");
            //Cambiar el hint del editText
            editTextOptions.setHint("Nombre, del recurso");
            //Cambiar el texto del boton
            botonBuscar.setText("Buscar");
            editTextOptions.setEnabled(true);
            Toast.makeText(getApplicationContext(), "Listo para buscar.!", Toast.LENGTH_SHORT).show();


            if (linearLayout.getVisibility() == View.GONE) {
                linearLayout.setVisibility(View.VISIBLE); // Muestra el LinearLayout
                // Buscar recurso
                botonBuscar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String query = editTextOptions.getText().toString();
                        searchResults.clear(); //limpiar busquedas anteriores
                        for (String resource : resourceList) {
                            if (resource.toLowerCase().contains(query.toLowerCase())) {
                                searchResults.add(resource);
                            }
                        }
                        ArrayAdapter<String> searchAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, searchResults);
                        resourceListView.setAdapter(searchAdapter);
                        // Oculta el LinearLayout
                        linearLayout.setVisibility(View.GONE); // Oculta el LinearLayout
                    }
                });
            } else {
                // Oculta el LinearLayout
                linearLayout.setVisibility(View.GONE); // Oculta el LinearLayout

            }
        }
    });

    // Configurar el botón de eliminar recurso
    deleteResourceButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Acciones a realizar cuando se hace clic en el botón
            //Cargar el layout vertical a mostrar
            LinearLayout linearLayout = findViewById(R.id.opciones);
            //Cargar el textview que se cambiar el titulo
            TextView textViewOptions = findViewById(R.id.textView3);
            //Cargar el editText que se quiere cambiar el hint
            EditText editTextOptions = findViewById(R.id.editTextTextPersonName);
            //Cargar el Button que se quiere cambiar el text
            Button botonEliminar = findViewById(R.id.buttonRealizar);

            //Cambiar el nombre del titulo a "Agregar Recurso"
            textViewOptions.setText("Eliminar Recurso");
            //Cambiar el hint del editText
            editTextOptions.setHint("Seleccione el recurso de la lista");
            //Cambiar el texto del boton
            botonEliminar.setText("Eliminar");
            editTextOptions.setEnabled(false);
            // Eliminar recurso
            if (linearLayout.getVisibility() == View.GONE) {
                linearLayout.setVisibility(View.VISIBLE); // Muestra el LinearLayout
                adapter.notifyDataSetChanged(); // Notificar al adaptador que los datos pueden haber cambiado.
                // Configurar el ListView para rellenar el EditText cuando se selecciona un elemento.
                resourceListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String selectedResource = adapter.getItem(position); // Obtener el recurso seleccionado.
                        editTextOptions.setText(selectedResource); // Poner el recurso seleccionado en el
                        // EditText.
                    }
                });

                // Configurar el botón de realizar
                botonEliminar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // obtener el nombre del recurso del EditText
                        String resourceName = editTextOptions.getText().toString();

                        // Verificar si el recurso existe en la lista
                        if (resourceList.contains(resourceName)) {
                            // Si el recurso existe, eliminarlo de la lista
                            resourceList.remove(resourceName);

                            // Limpiar el EditText
                            editTextOptions.setText("");

                            // Notificar al adaptador que los datos han cambiado
                            adapter.notifyDataSetChanged();

                            // Opcional: mostrar un mensaje al usuario
                            Toast.makeText(getApplicationContext(), "Recurso eliminado", Toast.LENGTH_SHORT).show();
                            linearLayout.setVisibility(View.GONE);
                        } else {
                            // Opcional: mostrar un mensaje al usuario si el recurso no existe
                            Toast.makeText(getApplicationContext(), "Recurso no encontrado", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                // Limpiar el EditText
                editTextOptions.setText("");
            }else{
                linearLayout.setVisibility(View.GONE); // Oculta el LinearLayout
            }
        }
    });
}
}