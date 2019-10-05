//mi proyecto programa inventado
const int Trigger = 12;   //Pin digital 2 para el Trigger del sensor
const int Echo =9;//Pin digital 3 para el Echo del sensor
const  int  LED=4;
const  int  LED2=5;
const  int  LED3=6;
const int pinBuzzer = 2 ;
void setup() {
   Serial.begin(9600);//iniciailzamos la comunicación
  pinMode(Trigger, OUTPUT); //pin como salida
  pinMode(Echo, INPUT);  //pin como entrada
  digitalWrite(Trigger, LOW);//Inicializamos e l pin con 0
  pinMode(LED, OUTPUT);
  pinMode(LED2, OUTPUT);
  pinMode(LED3, OUTPUT);
  

}

void loop() {
 long t; //timepo que demora en llegar el eco
  long d; //distancia en centimetros

  digitalWrite(Trigger, HIGH);
  delayMicroseconds(10);          //Enviamos un pulso de 10us
  digitalWrite(Trigger, LOW);
  
  t = pulseIn(Echo, HIGH); //obtenemos el ancho del pulso
  d = t/59;
if(d>0&&d<20){
   Serial.print("..............alerta te estas asfixiando.............. ");
  Serial.print(d); 
  Serial.print("cm \n");
  digitalWrite(LED, HIGH); 
  delay(10);
   digitalWrite(LED, LOW); 
  tone(pinBuzzer, 540,300);
  delay(100);
  }
  else{
    if(d>20&&d<50){
       Serial.print("..........estas en zona de riesgo..........");
  Serial.print(d); 
  Serial.print("cm \n");
  digitalWrite(LED2, HIGH); 
  delay(10);
   digitalWrite(LED2, LOW); 
  tone(pinBuzzer, 440,250);
  delay(100);
      
    }
    else{
      if(d>40){
       Serial.print("..........estas a salvo ..........");
  Serial.print(d); 
  Serial.print("cm \n");
  digitalWrite(LED3, HIGH); 
  delay(10);
   digitalWrite(LED3, LOW); 
  tone(pinBuzzer, 120,150);
  delay(100);
      }
    }
    }
  }