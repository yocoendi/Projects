import React, { useState } from "react";
import { StyleSheet, SafeAreaView, Button, Text, View, TextInput, Switch, Image } from 'react-native';
import imgs from './img/thestocks.jpg';



export default function App() {
    const [isEnabled, setIsEnabled] = useState(null);
    const [nombre, setNombre] = useState();
    const [apellidos, setApellidos] = useState();
    const [edad, setEdad] = useState();
    const [correo, setCorreo] = useState();
    const [texto, setText] = useState('');
    const [validanombre, setValidaNombre] = useState(false);
    const [validaapellido, setValidaApellidos] = useState(false);
    const [validaedad, setValidaEdad] = useState(false);
    const [validacorreo, setValidaCorreo] = useState(false);
    

    
    function validarNombre(nombre) {
        const reg = /^[a-zA-ZÀ-ÿ\s]{1,40}$/;
        if (reg.test(nombre)) {
            setValidaNombre(true);
            setNombre(nombre)
        } else {
            setValidaNombre(false);
          
        }
    }

    function validarApellidos(apellidos) {
        const reg = /^[a-zA-ZÀ-ÿ\s]{1,40}$/;
        if (reg.test(apellidos)) {
            setValidaApellidos(true);
            setApellidos(apellidos)
        } else {
            setValidaApellidos(false);
          
        }
    }

    function validarEdad(edad) {
        const reg =  /^[0-9]+$/;
        if (reg.test(edad)) {
            setValidaEdad(true);
            setEdad(edad);
        } else {
            setValidaEdad(false);
          
        }
    }

    function validarCorreo(correo) {
        const reg = /^\w+([.-_+]?\w+)*@\w+([.-]?\w+)*(\.\w{2,40})+$/;
        if (reg.test(correo)) {
            setValidaCorreo(true);
            setCorreo(correo);
        } else {
            setValidaCorreo(false);
          
        }
    }

  




    const printText = () => {


        setText(`Mi nombre es ${nombre} ${apellidos} tengo ${edad} años, y mi correo es ${coreo}. Sexo: ${isEnabled ? "Mujer" : "Hombre"}`)
    }

    const reseTear = () => {

        setText("")
        setNombre("")
        setApellidos("")
        setEdad("")
        setCorreo("")


    }

    return (
        <SafeAreaView style={styles.container}>
            <Text style={styles.title}>Formulario</Text>
            <View style={styles.campos}>
                <Text style={styles.texto}>Nombre</Text>
                <TextInput
                         style={validanombre ? (
                            { borderWidth: 2, height: 35,width: 210, borderColor: 'green' }
                        ) : (
                            { borderWidth: 2, height: 35,width: 210, borderColor: 'red' }
                        )
                        }
                    placeholder="Nombre"
                    keyboardType="name-phone-pad"
                    onChangeText={nombre => validarNombre(nombre)}
                    value={nombre}
                />

            </View>
            <View style={styles.campos}>
                <Text style={styles.texto}>Apellidos</Text>
                <TextInput
                    style={validaapellido ? (
                        { borderWidth: 2, height: 35,width: 210, borderColor: 'green' }
                    ) : (
                        { borderWidth: 2, height: 35,width: 210, borderColor: 'red' }
                    )
                    }
                    placeholder="Apellidos"
                    keyboardType="default"
                    onChangeText={apellidos => validarApellidos(apellidos)}
                    value={apellidos}
                />
            </View>
            <View style={styles.campos}>
                <Text style={styles.texto}>Edad</Text>
                <TextInput
                    style={validaedad ? (
                        { borderWidth: 2, height: 35,width: 210, borderColor: 'green' }
                    ) : (
                        { borderWidth: 2, height: 35,width: 210, borderColor: 'red' }
                    )
                    }
                    placeholder="Edad"
                    keyboardType="numeric"
                    onChangeText={edad => validarEdad(edad)}
                    value={edad}
                />
            </View>
            <View style={styles.campos}>
                <Text style={styles.texto}>Correo</Text>
                <TextInput
                        style={validacorreo ? (
                            { borderWidth: 2, height: 35,width: 210, borderColor: 'green' }
                        ) : (
                            { borderWidth: 2, height: 35,width: 210, borderColor: 'red' }
                        )
                        }
                    placeholder="correo"
                    keyboardType="email-address"
                    onChangeText={correo => validarCorreo(correo)}
                    value={correo}

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
                    title={"Nuevo formulario"}
                />


            </View>
            <View>
                <Text>{texto}</Text>
                {texto === '' ? null : <Image style={styles.imagen} source={imgs} />}

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
        width: 100,
        textAlign: "center"

    },
    title: {
        color: 'black',
        fontSize: 60,
        width: 400,


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

    imagen: {

        width: "100%",
        height: 200


    },

    input: {
        height: 35,
        width: 210,
        borderWidth: 1,
        padding: 0,
    }
})