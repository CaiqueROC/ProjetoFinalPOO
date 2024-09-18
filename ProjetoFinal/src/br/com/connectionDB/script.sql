select * from folha_pagamento fp 

CREATE table funcionario(
ID serial primary key,
nome varchar(60) not null,
cpf varchar(11) not null,
data_nascimento date,
salario_bruto decimal
);

CREATE table dependente(
ID serial primary key,
nome varchar(60) not null,
cpf varchar(11),
data_nascimento date not null,
parentesco varchar(20) not null,
id_funcionario int,
foreign key (id_funcionario) references funcionario(id)
);

CREATE table folha_pagamento(
ID serial primary key,
desconto_INSS decimal,
desconto_IR decimal,
salario_liquido decimal,
vale_transporte decimal,
id_funcionario int,
foreign key (id_funcionario) references funcionario(id),
data_calculo date
);