class MobibusesController < ApplicationController
  before_action :set_mobibus, only: [:show, :edit, :update, :destroy, :cambiar_posicion, :cambiar_estado]

  # GET /mobibuses
  # GET /mobibuses.json
  def index
    @mobibuses = Mobibus.all
  end

  # GET /mobibuses/1
  # GET /mobibuses/1.json
  def show
  end

  # GET /mobibuses/new
  def new
    @mobibus = Mobibus.new
  end

  # GET /mobibuses/1/edit
  def edit
  end

  # POST /mobibuses
  # POST /mobibuses.json
  def create
    @mobibus = Mobibus.new(mobibus_params)

    respond_to do |format|
      if @mobibus.save
        format.html { redirect_to @mobibus, notice: 'Mobibus was successfully created.' }
        format.json { render :show, status: :created, location: @mobibus }
      else
        format.html { render :new }
        format.json { render json: @mobibus.errors, status: :unprocessable_entity }
      end
    end
  end

  # PATCH/PUT /mobibuses/1
  # PATCH/PUT /mobibuses/1.json
  def update
    respond_to do |format|
      if @mobibus.update(mobibus_params)
        format.html { redirect_to @mobibus, notice: 'Mobibus was successfully updated.' }
        format.json { render :show, status: :ok, location: @mobibus }
      else
        format.html { render :edit }
        format.json { render json: @mobibus.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /mobibuses/1
  # DELETE /mobibuses/1.json
  def destroy
    @mobibus.destroy
    respond_to do |format|
      format.html { redirect_to mobibuses_url, notice: 'Mobibus was successfully destroyed.' }
      format.json { head :no_content }
    end
  end

  #Devulve la posicion actual del vehiculo
  #PUT /mobibuses/{id}/posicion
  def cambiar_posicion
    @mobibus.update_attribute(:posicion,params[:posicion])
  end

  def cambiar_estado
    @mobibus.update_attribute(:posicion,params[:posicion])
  end

  private
    # Use callbacks to share common setup or constraints between actions.
    def set_mobibus
      @mobibus = Mobibus.find(params[:id])
    end

    # Never trust parameters from the scary internet, only allow the white list through.
    def mobibus_params
      params.require(:mobibus).permit(:posicion, :estado, :kilms_ultima_revision)
    end




end
