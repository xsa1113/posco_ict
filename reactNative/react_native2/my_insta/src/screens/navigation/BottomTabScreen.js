import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import { NavigationContainer } from '@react-navigation/native';
import { Settings } from 'react-native';
import MaterialCommunityIcons from 'react-native-vector-icons/MaterialCommunityIcons';
import IonIcon from 'react-native-vector-icons/Ionicons';

import HomeScreen from "../HomeScreen"
import ProfileScreen from '../ProfileScreen';
import SelectScreen from '../SelectScreen';


const Tab = createBottomTabNavigator();

function BottomTabScreen() {
  return (
      <NavigationContainer>
    <Tab.Navigator
      initialRouteName="Home"
      screenOptions={{
        tabBarActiveTintColor: '#e91e63',
        headerShown:false
      }}
    >
      <Tab.Screen
        name="home"
        component={HomeScreen}
        options={{
          tabBarLabel: 'home',
          tabBarIcon: ({ color, size }) => (
            <MaterialCommunityIcons name="home" color={color} size={size} />
          ),
        }}
      />
      <Tab.Screen
        name="select"
        component={SelectScreen}
        options={{
          tabBarLabel: 'select',
          tabBarIcon: ({ color, size }) => (
            <IonIcon name="search" color={color} size={size} />
          ),
          tabBarBadge: 10,
        }}
      />
      
      <Tab.Screen
        name="profile"
        component={ProfileScreen}
        options={{
          tabBarLabel: 'profile',
          tabBarIcon: ({ color, size }) => (
            <MaterialCommunityIcons name="account" color={color} size={size} />
          ),
        }}
      />
    </Tab.Navigator>
    </NavigationContainer>
  );
}

export default BottomTabScreen;