import * as React from 'react';
import { View, Text, Button, StyleSheet, TouchableOpacity } from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import Ionicons from 'react-native-vector-icons/Ionicons';




    function HomeScreen({ navigation }) {
        return (
            <View style={{ flex: 1, alignItems: 'center', justifyContent: 'center' }}>
                <Text>Contactos</Text>
                    <TouchableOpacity onPress={() => navigation.navigate("Profile", { userName: 'Daniel', firstName: 'Camacho', lastName: 'Moraleda', edad: 19 })}>
                        <Text>Dani</Text>
                    </TouchableOpacity>
                      
                    
                
                <View style={styles.botones}>
                    <Button
                        onPress={() => navigation.navigate("Profile", { userName: 'Jorge',firstName: 'Camacho', lastName: 'Moraleda', edad: 44 })}
                        title={"Jorge"}
                    />
                </View>
                <View style={styles.botones}>
                    <Button
                        onPress={() => navigation.navigate("Profile", { userName: 'Carlos', firstName: 'Camacho', lastName: 'Moraleda', edad: 39 })}
                        title={"Carlos"}
                    />
                </View>
                <View style={styles.botones}>
                    <Button
                        onPress={() => navigation.navigate("Profile", { userName: 'Carlos',firstName: 'Camacho', lastName: 'Moraleda', edad: 18 })}
                        title={"Lucas"}
                    />
                </View>

              
            </View>
        );
    }



    function ProfilePrincipal({ route }) {
        const { userName,firstName,lastName,edad } = route.params
        return (
            <View style={{ flex: 1, alignItems: 'center', justifyContent: 'center' }}>
                <Text>{userName},{firstName},{lastName},{edad}</Text>
            </View>
        );
    }

    function Ajustes() {
        return (
            <View style={{ flex: 1, alignItems: 'center', justifyContent: 'center' }}>
            <Text>Ajustes</Text>
            </View>
           
           
        );
    }

    function GrupoHome (){
    return(
             <Stack.Navigator inicialRouteName="Profile">
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
              iconName = focused ? 'home': 'home-outline';
            } else if (route.name === 'Settings') {
              iconName = focused ? 'bandage' : 'bandage-outline';
            } 

            // You can return any component that you like here!
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
    botones: {
        marginLeft: 40,
        marginRight: 40,
        marginBottom: 5,
        marginTop: 5
    }

    

})