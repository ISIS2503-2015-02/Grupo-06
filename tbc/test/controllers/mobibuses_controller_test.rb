require 'test_helper'

class MobibusesControllerTest < ActionController::TestCase
  setup do
    @mobibus = mobibuses(:one)
  end

  test "should get index" do
    get :index
    assert_response :success
    assert_not_nil assigns(:mobibuses)
  end

  test "should get new" do
    get :new
    assert_response :success
  end

  test "should create mobibus" do
    assert_difference('Mobibus.count') do
      post :create, mobibus: { estado: @mobibus.estado, kilms_ultima_revision: @mobibus.kilms_ultima_revision, posicion: @mobibus.posicion }
    end

    assert_redirected_to mobibus_path(assigns(:mobibus))
  end

  test "should show mobibus" do
    get :show, id: @mobibus
    assert_response :success
  end

  test "should get edit" do
    get :edit, id: @mobibus
    assert_response :success
  end

  test "should update mobibus" do
    patch :update, id: @mobibus, mobibus: { estado: @mobibus.estado, kilms_ultima_revision: @mobibus.kilms_ultima_revision, posicion: @mobibus.posicion }
    assert_redirected_to mobibus_path(assigns(:mobibus))
  end

  test "should destroy mobibus" do
    assert_difference('Mobibus.count', -1) do
      delete :destroy, id: @mobibus
    end

    assert_redirected_to mobibuses_path
  end
end
