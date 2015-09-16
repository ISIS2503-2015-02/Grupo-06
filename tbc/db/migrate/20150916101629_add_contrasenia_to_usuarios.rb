class AddContraseniaToUsuarios < ActiveRecord::Migration
  def change
    add_column :usuarios, :contrasenia, :text
  end
end
