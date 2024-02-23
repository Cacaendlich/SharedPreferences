// Declara o pacote onde a classe SharedPreferencesActivity está localizada.
package com.camilaendlich.sharedpreferences

/* Importa classes e recursos necessários para a atividade,
 *incluindo classes de componentes de interface do usuário,
 *classes relacionadas ao sistema Android e a classe de ligação (binding) para a atividade.*/
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.camilaendlich.sharedpreferences.databinding.ActivitySharedPreferencesBinding

// Declaração da classe SharedPreferencesActivity, que estende AppCompatActivity, uma classe base para atividades no Android.
class SharedPreferencesActivity : AppCompatActivity() {
    // Declara variáveis que representam os componentes da interface do usuário, como EditText, Button e TextView.
    private lateinit var binding: ActivitySharedPreferencesBinding

    private lateinit var nomeEditText: EditText
    private lateinit var telefoneEditText: EditText
    private lateinit var idadeEditText: EditText
    private lateinit var gravarButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        // Método onCreate onde a inicialização da atividade é realizada,
        // inflando(seja que porra é essa) o layout usando o objeto de ligação (binding) e
        // configurando o conteúdo da atividade para a raiz do layout inflado.
        super.onCreate(savedInstanceState)
        binding = ActivitySharedPreferencesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        gravarButton = binding.btnSave
        nomeEditText = binding.name
        telefoneEditText = binding.tel
        idadeEditText = binding.age

        // Define o foco para o EditText do nome quando a atividade é criada.
        nomeEditText.requestFocus()

        // Lógica para preencher os EditText com os valores dos SharedPreferences se existirem
        if (checarPrefsIsNotEmpty()){
            val (name, tel, age) = consultarSharedPrefs()
            preencherInputs(name, tel, age)
            Toast.makeText(this, "Welcome back!", Toast.LENGTH_LONG).show()
        }

        gravarButton.setOnClickListener {
            // Lógica para gravar os dados nos SharedPreferences quando o botão é clicado
                val editor = getSharedPreferences("my_prefs", MODE_PRIVATE).edit()

                editor.putString("name", nomeEditText.text.toString())
                editor.putString("tel", telefoneEditText.text.toString())
                editor.putString("age", idadeEditText.text.toString())

                editor.apply()

                Toast.makeText(this, "Data recorded successfully!", Toast.LENGTH_LONG).show()
        }

    }

    private fun checarPrefsIsNotEmpty(): Boolean {
        val sharedPreferences = getSharedPreferences("my_prefs", MODE_PRIVATE)
        return sharedPreferences.contains("name")
    }

    private fun consultarSharedPrefs(): Triple<String, String, String> {
        //O Triple em Kotlin é uma classe que permite armazenar três valores em uma única estrutura de dados
        val sharedPreferences = getSharedPreferences("my_prefs", MODE_PRIVATE)
        val name = sharedPreferences.getString("name", "") ?: ""
        val telefone = sharedPreferences.getString("tel","") ?: ""
        val idade = sharedPreferences.getString("age", "") ?: ""
        return Triple(name, telefone, idade)
    }

    private fun preencherInputs(name: String, tel: String, age: String) {
        nomeEditText.setText(name)
        telefoneEditText.setText(tel)
        idadeEditText.setText(age)
    }
}
