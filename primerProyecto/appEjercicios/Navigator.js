import * as React from 'react';
import { View, Text, Button, StyleSheet, TouchableOpacity } from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import Ionicons from 'react-native-vector-icons/Ionicons';
import { visitors } from '@babel/traverse';

function HomeScreen({ navigation }) {
    return (
        <View >

            <TouchableOpacity onPress={() => navigation.navigate("Profile", { userName: 'Daniel', firstName: 'Camacho', lastName: 'Moraleda', edad: 19 })}>
                <Text style={styles.texto}>Dani</Text>
            </TouchableOpacity>

            <TouchableOpacity onPress={() => navigation.navigate("Profile", { userName: 'Daniel', firstName: 'Camacho', lastName: 'Moraleda', edad: 44 })}>
                <Text style={styles.texto}>Jorge</Text>
            </TouchableOpacity>

            <TouchableOpacity onPress={() => navigation.navigate("Profile", { userName: 'Daniel', firstName: 'Camacho', lastName: 'Moraleda', edad: 19 })}>
                <Text style={styles.texto}>Carlos</Text>
            </TouchableOpacity>

            <TouchableOpacity onPress={() => navigation.navigate("Profile", { userName: 'Daniel', firstName: 'Camacho', lastName: 'Moraleda', edad: 19 })}>
                <Text style={styles.texto}>Lucas</Text>
            </TouchableOpacity>

        </View>
    );
}

function ProfilePrincipal({ route }) {
    const { userName, firstName, lastName, edad } = route.params
    return (
        <View style={styles.view}>
            <Text>{userName},{firstName},{lastName},{edad}</Text>
        </View>
    );
}

function Ajustes() {
    return (
        <View style={styles.view}>
            <Text>Ajustes</Text>
        </View>


    );
}

function GrupoHome() {
    return (
        <Stack.Navigator>
            <Stack.Screen name="Home" component={HomeScreen} options={{ title: "Lista de Contactos" }} />
            <Stack.Screen name="Profile" component={ProfilePrincipal} options={{ title: "Datos de Contacto" }} />
        </Stack.Navigator>
    );
}


const Stack = createNativeStackNavigator();
const Tab = createBottomTabNavigator();


export default function App() {

    return (


        <NavigationContainer>

            <Tab.Navigator
                screenOptions={({ route }) => ({
                    tabBarIcon: ({ focused, color, size }) => {
                        let iconName;

                        if (route.name === 'Home') {
                            iconName = focused ? 'home' : 'home-outline';
                        } else if (route.name === 'Settings') {
                            iconName = focused ? 'bandage' : 'bandage-outline';
                        }

                        return <Ionicons name={iconName} size={size} color={color} />;
                    },
                    tabBarActiveTintColor: 'green',
                    tabBarInactiveTintColor: 'blue',
                })}
            >
                <Tab.Screen name="Home" component={GrupoHome} />
                <Tab.Screen name="Settings" component={Ajustes} />

            </Tab.Navigator>

        </NavigationContainer>

    );

}

const styles = StyleSheet.create({


    texto: {
        color: 'black',
        fontSize: 20,
        width: 100,
       
    },

    view: {

        flex: 1, 
        alignItems: 'center', 
        justifyContent: 'center'

    }

})