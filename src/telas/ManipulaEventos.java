/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import classes.Agenda;
import classes.Evento;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author kikol
 */
public final class ManipulaEventos extends javax.swing.JFrame {
    
    public String modo;
    public Agenda agenda;
    public ArrayList <Agenda> listaAgendas;
    
    public void loadTable(){
        
        DefaultTableModel modelo = new DefaultTableModel(new Object[] {"Código", "Nome","Data" , "Horário","Duração", "Global", },0);
        tbEventos.setModel(modelo);
        for(int i = 0; i < agenda.eventos.size(); i++){
            Object linha[] = new Object[]{ agenda.eventos.get(i).getId(), 
                                           agenda.eventos.get(i).getNome(),
                                           agenda.eventos.get(i).dataToString(),
                                           agenda.eventos.get(i).getHorario(),
                                           agenda.eventos.get(i).getDuracao(),
                                           agenda.eventos.get(i).isGlobal()};

            modelo.addRow(linha);
        }
        
    }
    public void loadTableMes(int mes){
        
        DefaultTableModel modelo = new DefaultTableModel(new Object[] {"Código", "Nome","Data" , "Horário","Duração", "Global", },0);
        tbEventos.setModel(modelo);
        
        ArrayList <Evento> listaEventos;
        
        listaEventos = agenda.getByMonth(mes);
        if(listaEventos != null){
            for(int i = 0; i < listaEventos.size(); i++){
                Object linha[] = new Object[]{ listaEventos.get(i).getId(), 
                                               listaEventos.get(i).getNome(),
                                               listaEventos.get(i).dataToString(),
                                               listaEventos.get(i).getHorario(),
                                               listaEventos.get(i).getDuracao(),
                                               listaEventos.get(i).isGlobal()};

                modelo.addRow(linha);
            }
        }
        
    }
    public void loadTableDia(int dia){
        
        DefaultTableModel modelo = new DefaultTableModel(new Object[] {"Código", "Nome","Data" , "Horário","Duração", "Global", },0);
        tbEventos.setModel(modelo);
        
        ArrayList <Evento> listaEventos;
        listaEventos = agenda.getByDay(dia);
        
        if(listaEventos != null){
            for(int i = 0; i < listaEventos.size(); i++){
                Object linha[] = new Object[]{ listaEventos.get(i).getId(), 
                                               listaEventos.get(i).getNome(),
                                               listaEventos.get(i).dataToString(),
                                               listaEventos.get(i).getHorario(),
                                               listaEventos.get(i).getDuracao(),
                                               listaEventos.get(i).isGlobal()};

                modelo.addRow(linha);
            }
        }
        
    }

    /**
     * Creates new form ManipulaEventos
     * @param listaAgendas
     * @param agenda
     */
    public ManipulaEventos(ArrayList listaAgendas, Agenda agenda){
        initComponents();
        setLocationRelativeTo(null);
        lblProprietario.setText("Agenda do " +agenda.getNomeAgenda());
        txtId.setEditable(false);   
        modo = "Navegar";
        this.agenda = agenda;
        this.listaAgendas = listaAgendas;
        loadTable();
        manipulaInterface();
        
    }
    
    public void manipulaInterface(){
        switch(modo){
            case "Navegar" :
                txtNome.setEnabled(false);
                txtHorario.setEnabled(false);
                txtDuracao.setEnabled(false);
                rdGlobal.setEnabled(false);
                jCal.getDayChooser().setEnabled(false);
                jCal.getMonthChooser().setEnabled(false);
                jCal.getYearChooser().setEnabled(false);
                btnSalvar.setEnabled(false);
                btnCancelar.setEnabled(false);
                btnLimpar.setEnabled(false);
                btnNovo.setEnabled(true);
                btnEditar.setEnabled(false);
                btnExcluir.setEnabled(false);
                rdTodos.setEnabled(true);
                rdMensal.setEnabled(true);
                rdDiaria.setEnabled(true);
                break;
                
            case "Novo" :
                txtNome.setEnabled(true);
                txtHorario.setEnabled(true);
                txtDuracao.setEnabled(true);
                rdGlobal.setEnabled(true);
                jCal.getDayChooser().setEnabled(true);
                jCal.getMonthChooser().setEnabled(true);
                jCal.getYearChooser().setEnabled(true);
                btnSalvar.setEnabled(true);
                btnCancelar.setEnabled(true);
                btnLimpar.setEnabled(true);
                btnNovo.setEnabled(false);
                btnEditar.setEnabled(false);
                btnExcluir.setEnabled(false);
                rdTodos.setEnabled(false);
                rdMensal.setEnabled(false);
                rdDiaria.setEnabled(false);
                break;
                
            case "Editar":
                txtNome.setEnabled(true);
                txtHorario.setEnabled(true);
                txtDuracao.setEnabled(true);
                rdGlobal.setEnabled(true);
                jCal.getDayChooser().setEnabled(true);
                jCal.getMonthChooser().setEnabled(true);
                jCal.getYearChooser().setEnabled(true);
                btnSalvar.setEnabled(true);
                btnCancelar.setEnabled(true);
                btnLimpar.setEnabled(true);
                btnNovo.setEnabled(false);
                btnEditar.setEnabled(false);
                btnExcluir.setEnabled(false);
                rdTodos.setEnabled(false);
                rdMensal.setEnabled(false);
                rdDiaria.setEnabled(false);
                break;
                
            case "Selecao":
                txtNome.setEnabled(false);
                txtHorario.setEnabled(false);
                txtDuracao.setEnabled(false);
                rdGlobal.setEnabled(false);
                jCal.getDayChooser().setEnabled(false);
                jCal.getMonthChooser().setEnabled(false);
                jCal.getYearChooser().setEnabled(false);
                btnSalvar.setEnabled(false);
                btnCancelar.setEnabled(false);
                btnLimpar.setEnabled(false);
                btnNovo.setEnabled(true);
                btnEditar.setEnabled(true);
                btnExcluir.setEnabled(true);
                rdTodos.setEnabled(true);
                rdMensal.setEnabled(true);
                rdDiaria.setEnabled(true);
                break;
                
            case "Mensal":
                txtNome.setEnabled(false);
                txtHorario.setEnabled(false);
                txtDuracao.setEnabled(false);
                rdGlobal.setEnabled(false);
                jCal.getDayChooser().setEnabled(false);
                jCal.getMonthChooser().setEnabled(true);
                jCal.getYearChooser().setEnabled(false);
                btnSalvar.setEnabled(false);
                btnCancelar.setEnabled(false);
                btnLimpar.setEnabled(false);
                btnNovo.setEnabled(true);
                btnEditar.setEnabled(false);
                btnExcluir.setEnabled(false);
                rdTodos.setEnabled(true);
                rdMensal.setEnabled(true);
                rdDiaria.setEnabled(true);
                break;
                
            case "Diaria":
                txtNome.setEnabled(false);
                txtHorario.setEnabled(false);
                txtDuracao.setEnabled(false);
                rdGlobal.setEnabled(false);
                jCal.getDayChooser().setEnabled(true);
                jCal.getMonthChooser().setEnabled(false);
                jCal.getYearChooser().setEnabled(false);
                btnSalvar.setEnabled(false);
                btnCancelar.setEnabled(false);
                btnLimpar.setEnabled(false);
                btnNovo.setEnabled(true);
                btnEditar.setEnabled(false);
                btnExcluir.setEnabled(false);
                rdTodos.setEnabled(true);
                rdMensal.setEnabled(true);
                rdDiaria.setEnabled(true);
                break;
                
            default: System.out.println("Modo inválido");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbEventos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        jCal = new com.toedter.calendar.JCalendar();
        rdGlobal = new javax.swing.JRadioButton();
        btnSalvar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtHorario = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDuracao = new javax.swing.JFormattedTextField();
        btnNovo = new javax.swing.JButton();
        lblProprietario = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        rdMensal = new javax.swing.JRadioButton();
        rdDiaria = new javax.swing.JRadioButton();
        lblVisualizacao = new javax.swing.JLabel();
        btnVisualizar = new javax.swing.JButton();
        rdTodos = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbEventos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Data", "Horário", "Duração", "Global"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbEventos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbEventosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbEventos);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Evento")));

        jLabel1.setText("Código");

        jLabel2.setText("Nome");

        jLabel3.setText("Horário");

        rdGlobal.setText("Global (comum à todas as agendas)");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        try {
            txtHorario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel4.setText("Duração");

        try {
            txtDuracao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtId))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(rdGlobal)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCal, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(rdGlobal)
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnLimpar)
                    .addComponent(btnCancelar))
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnNovo.setText("Novo Evento");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        lblProprietario.setText("Agenda do nome");

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdMensal);
        rdMensal.setText("Mês");
        rdMensal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdMensalMouseClicked(evt);
            }
        });

        buttonGroup1.add(rdDiaria);
        rdDiaria.setText("Dia");
        rdDiaria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdDiariaMouseClicked(evt);
            }
        });

        lblVisualizacao.setText("Seleção");

        btnVisualizar.setText("Visualizar");
        btnVisualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVisualizarMouseClicked(evt);
            }
        });

        buttonGroup1.add(rdTodos);
        rdTodos.setSelected(true);
        rdTodos.setText("Todos");
        rdTodos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdTodosMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(18, 369, Short.MAX_VALUE)
                        .addComponent(btnNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblProprietario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblVisualizacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdTodos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdMensal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdDiaria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVisualizar)
                        .addGap(2, 2, 2)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVisualizar)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblProprietario)
                        .addComponent(lblVisualizacao)
                        .addComponent(rdMensal)
                        .addComponent(rdDiaria)
                        .addComponent(rdTodos)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnEditar)
                    .addComponent(btnExcluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Eventos", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        // TODO add your handling code here:
        txtId.setText("");
        txtNome.setText("");
        txtHorario.setText("");
        txtDuracao.setText("");
        rdGlobal.setSelected(false);
        txtNome.requestFocus();
        modo = "Novo";
        manipulaInterface();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        modo = "Editar";
        manipulaInterface();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        int index = tbEventos.getSelectedRow();
        if(index>=0 && index < agenda.eventos.size()){
            agenda.eventos.remove(index);
        }
        modo = "Navegar";
        manipulaInterface();
        txtId.setText("");
        txtNome.setText("");
        txtHorario.setText("");
        txtDuracao.setText("");
        rdGlobal.setSelected(false);
        loadTable();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        if(modo.equals("Novo")){
            Evento e = new Evento(txtNome.getText(), jCal.getCalendar(), txtHorario.getText(), txtDuracao.getText(), rdGlobal.isSelected());
            txtId.setText(Integer.toString(e.getId()));
            
            if(e.isGlobal()){
                for(int i = 0; i < listaAgendas.size(); i++){
                        listaAgendas.get(i).addEvento(e);
                }
            }
            else{
                agenda.addEvento(e);
                
            }
        } 
        else if (modo.equals("Editar")){
            int index = tbEventos.getSelectedRow();
            
            if(agenda.eventos.get(index).isGlobal()){
                for(Agenda a : listaAgendas){
                    a.eventos.get(index).setNomeEvento(txtNome.getText());
                    a.eventos.get(index).setHorario(txtHorario.getText());
                    a.eventos.get(index).setDuracao(txtDuracao.getText());
                    a.eventos.get(index).setGlobal(rdGlobal.isSelected());
                    a.eventos.get(index).setData(jCal.getCalendar());
               }
            }
            else{
                agenda.eventos.get(index).setNomeEvento(txtNome.getText());
                agenda.eventos.get(index).setHorario(txtHorario.getText());
                agenda.eventos.get(index).setDuracao(txtDuracao.getText());
                agenda.eventos.get(index).setGlobal(rdGlobal.isSelected());
                agenda.eventos.get(index).setData(jCal.getCalendar());
            }
        }
        loadTable();
        modo = "Navegar";
        manipulaInterface();
        txtId.setText("");
        txtNome.setText("");
        txtHorario.setText("");
        txtDuracao.setText("");
        rdGlobal.setSelected(false);
        
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        txtId.setText("");
        txtNome.setText("");
        txtHorario.setText("");
        txtDuracao.setText("");
        rdGlobal.setSelected(false);
        modo = "Navegar";
        manipulaInterface();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tbEventosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbEventosMouseClicked
        // TODO add your handling code here:
        int index = tbEventos.getSelectedRow();
        if(index >= 0 && index < agenda.eventos.size()){
            Evento e  = agenda.eventos.get(index);
            txtNome.setText(e.getNome());
            txtId.setText(Integer.toString(e.getId()));
            txtHorario.setText(e.getHorario());
            txtDuracao.setText(e.getDuracao());
            rdGlobal.setSelected(e.isGlobal());
            jCal.setDate(e.getData());
        }
        modo = "Selecao";
        manipulaInterface(); 
    }//GEN-LAST:event_tbEventosMouseClicked

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        // TODO add your handling code here:
        txtId.setText("");
        txtNome.setText("");
        txtHorario.setText("");
        txtDuracao.setText("");
        rdGlobal.setSelected(false);
        txtNome.requestFocus();

    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnVisualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVisualizarMouseClicked
        // TODO add your handling code here:
        if(rdMensal.isSelected()){
            int mes = jCal.getMonthChooser().getMonth();
            loadTableMes(mes);
            
        }
        else if(rdDiaria.isSelected()){
            int dia = jCal.getDayChooser().getDay();
            loadTableDia(dia);
            
        }
        else if(rdTodos.isSelected()){
            loadTable();
        }
    }//GEN-LAST:event_btnVisualizarMouseClicked

    private void rdMensalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdMensalMouseClicked
        // TODO add your handling code here:
        modo = "Mensal";
        manipulaInterface();
        
        
    }//GEN-LAST:event_rdMensalMouseClicked

    private void rdDiariaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdDiariaMouseClicked
        // TODO add your handling code here:
        modo = "Diaria";
        manipulaInterface();
        
    }//GEN-LAST:event_rdDiariaMouseClicked

    private void rdTodosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdTodosMouseClicked
        // TODO add your handling code here:
        modo = "Navegar";
        manipulaInterface();
    }//GEN-LAST:event_rdTodosMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVisualizar;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JCalendar jCal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblProprietario;
    private javax.swing.JLabel lblVisualizacao;
    private javax.swing.JRadioButton rdDiaria;
    private javax.swing.JRadioButton rdGlobal;
    private javax.swing.JRadioButton rdMensal;
    private javax.swing.JRadioButton rdTodos;
    private javax.swing.JTable tbEventos;
    private javax.swing.JFormattedTextField txtDuracao;
    private javax.swing.JFormattedTextField txtHorario;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
