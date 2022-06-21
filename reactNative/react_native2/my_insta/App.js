import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View } from 'react-native';
import { SafeAreaProvider } from 'react-native-safe-area-context';
import { Provider } from 'react-redux';
import BottomTabScreen from './src/screens/navigation/BottomTabScreen';
import IndexNavigate from './src/screens/navigation/indexNavigate';
import store from "./src/store/store";


export default function App() {
  return (
    <Provider store ={store}>

    <SafeAreaProvider>
      <SafeAreaProvider style={{flex:1}}>
        <IndexNavigate></IndexNavigate>
      </SafeAreaProvider>
    </SafeAreaProvider>
    </Provider>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
