import React, { useState } from "react";
import { StyleSheet, Button, Text, View, TextInput } from 'react-native';



export default function App() {
  const [booleano, setBooleano] = useState(false);

  const [nombre, setNombre] = useState();
  const [apellidos, setApellidos] = useState();
  const [edad, setEdad] = useState();
  const [coreo, setCorreo] = useState();


  const [texto, setText] = useState();



  const printText = () => {

    setText(

      <Text style={{ flexDirection: 'row' }}>

        {edad == 18 ? <Text style={styles.texto}><Text style={styles.textoResulatdo}>Acaba de ser mayor</Text> de edad</Text>

        : edad < 18 ? <Text style={styles.texto}>Es <Text style={styles.textoResulatdo}>menor</Text> de edad</Text>

        : <Text style={styles.texto}>Es <Text style={styles.textoResulatdo}>mayor</Text> de edad</Text>}

      </Text>

    )

  }
  
  return (
    <View>


      <View style={{ flexDirection: 'row' }}>
        <Text style={styles.texto}>Hola mi nombre es </Text>
        <TextInput
        style={styles.input}
        placeholder="Nombre"
        keyboardType="name-phone-pad"
        onChangeText={nombre => setName(nombre)}
      />
      </View>
      <View style={{ flexDirection: 'row' }}>
        <Text style={styles.texto}>Hola mi nombre es </Text>
        <TextInput
        style={styles.input}
        placeholder="Nombre"
        keyboardType="name-phone-pad"
        onChangeText={edad => setEdad(edad)}
      />
      </View>
      <View style={{ flexDirection: 'row' }}>
        <Text style={styles.texto}>Hola mi nombre es </Text>
        <TextInput
        style={styles.input}
        placeholder="Nombre"
        keyboardType="name-phone-pad"
        onChangeText={apellidos => setApellidos(apellidos)}
      />
      </View>
      
      










   
      <Text>{texto}</Text>
      <View style={styles.botones}>
        <Button
          onPress={printText}
          title={"Finalizar"}
        />
      </View>
    </View>
  );



 
}



const styles = StyleSheet.create({
  texto: {
    color: 'black',
    fontSize: 20,
    paddingTop: 50
  },
  textoNombre: {
    color: 'blue',
    fontSize: 20,
    paddingTop: 50
  },
  botones: {
    paddingTop: 20,
    paddingBottom: 20,
    paddingLeft: 30,
    paddingRight: 30,
    borderRadius: 200,
  },
  input: {
    height: 40,
    margin: 12,
    borderWidth: 1,
    padding: 10,
  }
})