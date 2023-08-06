package com.example.myapplication

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.myapplication.ModelViews.SignUpModelView


class SignUp : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var signup: Button
    private lateinit var phonenumber: EditText
    private lateinit var email: EditText
    private lateinit var nameET: EditText
    private lateinit var password: EditText
    private lateinit var loginpage: TextView
    private lateinit var checkBox: CheckBox
    private lateinit var validation:Array<Actions>
    private val viewModel: SignUpModelView by viewModels()
    private var emailT:String=""
    private var passwordT=""
    private var phoneT=""
    private var nameT=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view)
        loginpage.setOnClickListener{
            findNavController().navigate(R.id.action_signUp_to_login2)
        }
        signup.setOnClickListener {
            var check=true
            for (i in validation){
                if (i.CheckMatching()){
                    continue
                }else{
                    check=false
                    break
                }
            }
            if(check && checkBox.isChecked){
                getValue()
                viewModel.signUp(emailT,passwordT,nameT)
            }else if (!checkBox.isChecked){
                Toast.makeText(context,"Please you have to agree our policy", Toast.LENGTH_LONG).show()
            }
        }

    }
    private fun init(view:View){
        signup=view.findViewById(R.id.m2signupBtn)
        email=view.findViewById(R.id.m2emailET)
        password=view.findViewById(R.id.m2passEd)
        phonenumber=view.findViewById(R.id.m2phoneNumEd)
        nameET=view.findViewById(R.id.m2cityET)
        validation= arrayOf(
                Actions(phonenumber, "[0][1]([0-2]|[5])\\d{8}","Phone Number must be eleven number"),
                Actions(email, "([a-zA-Z]|[0-9]|\\.|\\-|\\_)+\\@([a-zA-Z]|[0-9])+\\.com","it is not valid email"),
                Actions(password, "([a-zA-Z0-9]){8,}","password must be more than 8 character and contains digits and letters in english only"),
                Actions(nameET, "[a-zA-Z]{2,}","unValid nameET"),
        )
        loginpage=view.findViewById(R.id.m2loginET)
        checkBox=view.findViewById(R.id.checkbox)
    }
    private fun getValue() {
        emailT = email.text.toString()
        passwordT = password.text.toString()
        nameT=nameET.text.toString()
        phoneT=phonenumber.text.toString()
    }


    public fun Actions.CheckMatching():Boolean{
        if(!this.IsMatch()){
            Toast.makeText(context,this.EMessage,Toast.LENGTH_LONG).show()
            return false
        }
        return true
    }


    private fun observeStates() {
        viewModel.signLiveData.observe(viewLifecycleOwner) {
            val preferance=context?.getSharedPreferences("Login", Context.MODE_PRIVATE)
            val editor=preferance?.edit()

            editor?.putString("email",emailT)
            editor?.putString("password",passwordT)
            editor?.putString("nameET",nameT)
            editor?.apply()
            findNavController().navigate(R.id.action_signUp_to_commingSoonReciqule)
        }


        viewModel.signErrorLiveData.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }

    }
}