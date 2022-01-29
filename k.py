class node:
	def __init__(self,key,value):
		self.key=key
		self.value=value
		self.next=None

class hashmap:
	def __init__(self,size):
		self.size=size
		self.num=0;
		self.table=[[] for _ in range(self.size)]
	
	def hash(self,key):
		key = abs(key)
		return key%self.size
	
	def put(self,key,value):
		i = hash(key)
		t=self.table[i]
		for i in range(len(t)):#checking if key already exist if exist then update the value and return
			if(t[i].key is key):
				t[i].value=value
				return
		t.append(node(key,value))  #if key is not present append(key,value) to list
		self.num+=1
		
	def get(self,key):
		i = hash(key)
		t=self.table[i]
		for i in range(len(t)):
			if key == t[i].key:
				return t[i].value
		print("Key Error")
		return -999
		
	def remove(self,key):
		i=hash(key)
		t=self.table[i]
		for i in range(len(t)):
			if key is t[i].key:
				v=t[i].value
				del t[i]
				self.num-=1
				return v
		print("Key Error")
		return -999
	def no_of_elements(self):
		return self.num
		
	def print_map(self):
		for t in self.table:
			for x in t:
				print('key=',x.key,end='')
				print('val=',x.value)

mp=hashmap(10)
mp.put(1,2)
mp.put(3,5)
print(mp.get(3))
mp.put(3,66);
print(mp.get(3))
mp.get(-1)
mp.put(4,67)
mp.remove(4)
mp.remove(4)
mp.print_map()
print(mp.no_of_elements())
mp.remove(1)
print(mp.no_of_elements())
mp.print_map()
