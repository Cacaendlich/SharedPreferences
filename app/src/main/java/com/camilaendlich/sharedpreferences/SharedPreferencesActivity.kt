// Declara o pacote onde a classe SharedPreferencesActivity está localizada.
package com.camilaendlich.sharedpreferences

/* Importa classes e recursos necessários para a atividade,
 *incluindo classes de componentes de interface do usuário,
 *classes relacionadas ao sistema Android e a classe de ligação (binding) para a atividade.*/
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
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

        gravarButton = binding.btnGravar
        nomeEditText = binding.nome
        telefoneEditText = binding.telefone
        idadeEditText = binding.idade

        // Define o foco para o EditText do nome quando a atividade é criada.
        nomeEditText.requestFocus()

        // Lógica para preencher os EditText com os valores dos SharedPreferences se existirem
        if (checarPrefsIsNotEmpty()){
            val (name, telefone, idade) = consultarSharedPrefs()
            preencherInputs(name, telefone, idade)
            Toast.makeText(this, "Bem vindo de volta!", Toast.LENGTH_LONG).show()
        }

        gravarButton.setOnClickListener {
            // Lógica para gravar os dados nos SharedPreferences quando o botão é clicado
                val editor = getSharedPreferences("minhas_preferences", MODE_PRIVATE).edit()

                editor.putString("nome", nomeEditText.text.toString())
                editor.putString("telefone", telefoneEditText.text.toString())
                editor.putString("idade", idadeEditText.text.toString())

                editor.apply()

                Toast.makeText(this, "Dados gravados com sucesso!", Toast.LENGTH_SHORT).show()
        }

    }

    private fun checarPrefsIsNotEmpty(): Boolean {
        val sharedPreferences = getSharedPreferences("minhas_preferences", MODE_PRIVATE)
        return sharedPreferences.contains("nome")
    }

    private fun consultarSharedPrefs(): Triple<String, String, String> {
        //O Triple em Kotlin é uma classe que permite armazenar três valores em uma única estrutura de dados
        val sharedPreferences = getSharedPreferences("minhas_preferences", MODE_PRIVATE)
        val name = sharedPreferences.getString("nome", "") ?: ""
        val telefone = sharedPreferences.getString("telefone","") ?: ""
        val idade = sharedPreferences.getString("idade", "") ?: ""
        return Triple(name, telefone, idade)
    }

    private fun preencherInputs(nome: String, telefone: String, idade: String) {
        nomeEditText.setText(nome)
        telefoneEditText.setText(telefone)
        idadeEditText.setText(idade)
    }
}
