import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View } from 'react-native';
import { SafeAreaView } from 'react-native';
import { SectionList } from 'react-native';
import BasicComponent from './src/screens/BasicComponent';
import ListClickComponent from './src/screens/ListClickComponent';
import ListComponent from './src/screens/ListComponent';
import SectionListComponent from './src/screens/SectionListComponent';
import VirtualizedListComponent from './src/screens/VirtualizedListComponent';

export default function App() {
  return (
    <SafeAreaView  style={styles.container}>
      {/* <BasicComponent props={"title"}></BasicComponent>
       */}
       {/* <ListComponent></ListComponent>
        */}
       
       <ListClickComponent></ListClickComponent>
        
        {/* <SectionListComponent></SectionListComponent>
         */}

         {/* <VirtualizedListComponent></VirtualizedListComponent> */}
    </SafeAreaView>

  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
  test: {
    backgroundColor: 'red',
  },
  test1: {
    backgroundColor: 'blue',
  },
  box:{
    width:100,
    height:100,
  },
  row:{
    flexDirection: 'row',

  }
});
