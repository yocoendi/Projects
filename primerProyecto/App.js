import React, { useState } from "react";
import { StyleSheet, Button, Text, View, TextInput,Switch } from 'react-native';



export default function App() {
    const [isEnabled, setIsEnable] = useState(null);
    const [nombre, setNombre] = useState();
    const [apellidos, setApellidos] = useState();
    const [edad, setEdad] = useState();
    const [coreo, setCorreo] = useState();
    const [sexo, setSexo] = useState();
    const [texto, setText] = useState();



    const printText = () => {

        setText(

            <Text style={{ flexDirection: 'row' }}>

                <Text>Mi nombre es {nombre} {apellidos} tengo {edad} años, y mi correo es {coreo} {isEnabled? <Text>Hombre</Text>:<Text>Mujer</Text>}</Text>

            </Text>

        )

    }

    return (
        <View>


            <View style={{ flexDirection: 'row' }}>
                <Text style={styles.texto}>Nombre</Text>
                <TextInput
                    style={styles.input}
                    placeholder="Nombre"
                    keyboardType="name-phone-pad"
                    onChangeText={nombre => setNombre(nombre)}
                />
            </View>

            <View style={{ flexDirection: 'row' }}>
                <Text style={styles.texto}>Apellidos</Text>
                <TextInput
                    style={styles.input}
                    placeholder="Apellidos"
                    keyboardType="default"
                    onChangeText={apellidos => setApellidos(apellidos)}
                />
            </View>

            <View style={{ flexDirection: 'row' }}>
                <Text style={styles.texto}>Edad</Text>
                <TextInput
                    style={styles.input}
                    placeholder="Edad"
                    keyboardType="numeric"
                    onChangeText={edad => setEdad(edad)}
                />
            </View>

            <View style={{ flexDirection: 'row' }}>
                <Text style={styles.texto}>Correo</Text>
                <TextInput
                    style={styles.input}
                    placeholder="correo"
                    keyboardType="email-address"
                    onChangeText={correo => setCorreo(correo)}
                />
                
                <Switch
                    trackColor={{ false: 'red', true: 'blue' }}
                    thumbColor={isEnabled ? 'blue' : 'red'}
                    onValueChange={() => setIsEnabled((previousState) => !previousState)}
                    value={isEnabled}
                />

            </View>




            <View style={styles.botones}>
                <Button
                    onPress={printText}
                    title={"Enviar"}
                />
                <Text>{texto}</Text>
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
        padding: 14,
    }
})