import React, { useState } from "react";
import { StyleSheet,SafeAreaView, Button, Text, View, TextInput, Switch, Image } from 'react-native';
import imgs from './img/thestocks.jpg';



export default function App() {
    const [isEnabled, setIsEnabled] = useState(null);
    const [nombre, setNombre] = useState();
    const [apellidos, setApellidos] = useState();
    const [edad, setEdad] = useState();
    const [coreo, setCorreo] = useState();
    const [texto, setText] = useState('');
    


    const printText = () => {

       
        setText(`Mi nombre es ${nombre} ${apellidos} tengo ${edad} años, y mi correo es ${coreo}. Sexo: ${isEnabled ? "Mujer" : "Hombre"}`)
    }

    const reseTear = () => {

        setNombre("")
        setApellidos("")
        setEdad("")
        setCorreo("")
        setText("")
        
    }

    return (
        <SafeAreaView style={styles.container}>
            <View style={styles.campos}>
                <Text style={styles.texto}>Nombre</Text>
                <TextInput
                    style={styles.input}
                    placeholder="Nombre"
                    keyboardType="name-phone-pad"
                    onChangeText={nombre => setNombre(nombre)}
                />
            </View>
            <View style={styles.campos}>
                <Text style={styles.texto}>Apellidos</Text>
                <TextInput
                    style={styles.input}
                    placeholder="Apellidos"
                    keyboardType="default"
                    onChangeText={apellidos => setApellidos(apellidos)}
                />
            </View>
            <View style={styles.campos}>
                <Text style={styles.texto}>Edad</Text>
                <TextInput
                    style={styles.input}
                    placeholder="Edad"
                    keyboardType="numeric"
                    onChangeText={edad => setEdad(edad)}
                />
            </View>
            <View style={styles.campos}>
                <Text style={styles.texto}>Correo</Text>
                <TextInput
                    style={styles.input}
                    placeholder="correo"
                    keyboardType="email-address"
                    onChangeText={correo => setCorreo(correo)}
                />
            </View>
            <View style={styles.campos}>
                <Text>Sexo: Hombre </Text>
                <Switch
                    trackColor={{ false: 'red', true: 'blue' }}
                    thumbColor={isEnabled ? 'blue' : 'red'}
                    onValueChange={() => setIsEnabled((previousState) => !previousState)}
                    value={isEnabled}
                />
                <Text>Mujer </Text>
            </View>

            <View style={styles.fixToText}>
                <Button
                    onPress={printText}
                    title={"Enviar"}
                />
                    <Button
                    onPress={reseTear}
                    title={"Resetear"}
                />
                
                
            </View>
            <View>
            <Text>{texto}</Text>
                {texto===''?null:<Image style={styles.imagen} source={imgs}/>}
            </View>
        </SafeAreaView>
    );




}

const styles = StyleSheet.create({

    container: {
        flex: 1,
        padding: 30,
       
    },
    campos: {
        flexDirection: 'row',
        marginVertical: 10
    },
    botones: {
        paddingTop: 20,
        paddingBottom: 20,
 
        borderRadius: 200,
        //backgroundColor: 'white'
    },
    texto: {
        color: 'black',
        fontSize: 20,
        width: 90

    },
    fixToText: {
        flexDirection: 'row',
        justifyContent: 'space-evenly',
      },
    textoNombre: {
        color: 'blue',
        fontSize: 20,
        paddingTop: 50
    },

    imagen:{

        width:"100%",
        height: 200


    },

    input: {
        height: 20,
        width: 120,
        borderWidth: 1,
        padding: 1,
    }
})